import { APIGatewayProxyEvent } from 'aws-lambda';
import { Handler } from 'aws-lambda';
import { ListBucketsCommand, ListObjectsV2Command, GetObjectCommand, S3Client } from "@aws-sdk/client-s3";
import * as path from "node:path";


const client = new S3Client({});


export const getBuckets:Handler = async () => {

    const command = new ListBucketsCommand({});

    try{
        const { Owner, Buckets } = await client.send(command);
        if(Buckets){
            return {
                statusCode: 200,
                body: JSON.stringify(Buckets)
            };
        }
    }catch (err){
        console.error(err);
        return {
            statusCode: 500,
            body: JSON.stringify(err)
        };
    }
}

export const getObjects:Handler = async (event) => {

    console.log(`event = ${event}`);

    const pathParameters = event.pathParameters;
    const command = new ListObjectsV2Command({
        Bucket: pathParameters.bucketName
    });

    try{
        const response = await client.send(command);
        if(response){
            return {
                statusCode: 200,
                body: JSON.stringify(response)
            };
        }
    }catch (err){
        console.error(err);
        return {
            statusCode: 500,
            body: JSON.stringify(err)
        };
    }
}

export const getObject:Handler = async (event, context) => {


    return {
        statusCode: 200,
        body: {
            event: event,
            context: JSON.stringify(context)
        }
    };
}
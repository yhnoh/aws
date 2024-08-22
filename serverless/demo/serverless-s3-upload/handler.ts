import { Handler } from 'aws-lambda';
import { ListBucketsCommand, S3Client } from "@aws-sdk/client-s3";

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
        return {
            statusCode: 500,
            body: JSON.stringify(err)
        };
    }
}


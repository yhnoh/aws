import request from "supertest";
import { describe } from "node:test";
import { createApp, RedisClient, LIST_KEY } from "./app";
import * as redis from "redis";


let app: any;
let client: RedisClient;

beforeAll(async () => {
    client = redis.createClient({url:"redis://localhost:6379"});
    await client.connect();
    app = createApp(client);
});

beforeEach(async () => {
    await client.flushDb();
})

afterAll(async () => {
    await client.flushDb();
    await client.quit();
});

describe("POST /messages", () => {
    it("response success message", async () => {

        const response = await request(app)
            .post("/messages")
            .send({message: "test redis"});

        expect(response.statusCode).toBe(200);
        expect(response.text).toBe("success input message");
    })
})

describe("GET /messages", () => {
    it("response success message", async () => {

        await client.lPush(LIST_KEY, ["message1","message2"]);

        const response = await request(app)
            .get("/messages");

        expect(response.statusCode).toBe(200);
        expect(response.body).toEqual(["message2","message1"]);
    })
})
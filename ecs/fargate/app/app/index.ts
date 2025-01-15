import express from "express";

const app = express();

app.use(express.json());

app.get("/", (request, response) => {
    response.status(200).send("hello world")
})

const PORT = 4000;

app.listen(PORT, () => {
    console.log(`start app by port ${PORT}`)
})

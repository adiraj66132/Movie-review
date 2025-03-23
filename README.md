# Movie Review App (Full Stack)
The responsive Movie Review web application is a platform where users can add reviews to movies and watch their trailers. The app enables users to interact with movie reviews, provides an intuitive frontend using React, and ensures efficient data storage and retrieval with MongoDB integrated through Spring Boot.

![preview](./movie-client/public/preview.png)

## 👨‍💻 Built With
* [![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)](https://react.dev/)
* [![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
* [![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/)
* [![MUI](https://img.shields.io/badge/MUI-%230081CB.svg?style=for-the-badge&logo=mui&logoColor=white)](https://mui.com/)

## ⚙️ Local Setup and Installation
* Clone this repository.
```
$ git clone https://github.com/aviralj02/movie-review-app.git
```
* Install NPM packages for movie-client.
```
$ cd movie-client
$ npm install
```
* Create a .env file for movie-api and fill up the project details just like [env.example](./movie-api/src/main/resources/.env.example)
* Install packages for movie-api by doing Maven Install in your preferred Java IDE (Eclipse/Idea/STS).
* Spin up the development server for movie-client.
```
$ npm run dev
``` 
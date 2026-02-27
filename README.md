# Spotify Clone – Backend API
 
This project provides REST APIs for user authentication and music management with basic audio playback support.

## Features

- User Registration
- User Login (Basic Authentication logic)
- Add Song
- Get All Songs
- Get Song by ID
- Update Song (Partial update supported)
- Delete Song
- Audio file served from static folder

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## API Endpoints

### User APIs
- POST /user/register
- POST /user/login

### Song APIs
- POST /song
- GET /song
- GET /song/{id}
- PUT /song/{id}
- DELETE /song/{id}

## Database

Two tables are used:
- users (id, username, password)
- songs (id, title, artist, duration, url)

## Author

Adhavan M

h## Author

Adhavan M

# Practice Automation Framework

UI and API test automation framework using Selenium Grid + Docker.

## Stack
- Java 21
- Selenium WebDriver
- TestNG
- Allure Reports
- REST Assured
- Docker + Selenium Grid

## Prerequisites
- Java 21
- Maven
- Docker Desktop
- Allure CLI

## How to run

1. Clone the repo
2. Run the script:
```bash
.\run-tests.bat
```

The script will:
- Start Selenium Grid on Docker
- Run the tests
- Open the Allure report automatically

## Environment variables

Create a `.env` file in the root of the project with the following variables:
```
REQRES_API_KEY=your_api_key_here
SELENIUM_GRID_URL=http://localhost:4444
```

Get your free API key at https://reqres.in

@echo off
echo Opening Selenium Grid...
docker-compose up -d

echo Waiting for the grid to be ready...
timeout /t 10 /nobreak

echo Running tests...
call mvn clean test

echo Looking for Allure results...
if exist "target\allure-results" (
    echo Opening report from target...
    allure serve target/allure-results
) else if exist "allure-results" (
    echo Opening report from root...
    allure serve allure-results
) else (
    echo ERROR: No results from Allure were found.
)
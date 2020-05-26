# Read Me First
* The application consumes from csv example file called 'car-data.csv',
* Process every row, doing an uppercase
* Afterwards the result is exported to 'car-data-output.csv', 
* Finally, the file is sent to Amazon S3 bucket

# Run the application
* Add Your Amazon S3 secrets in application.properties
* Just run main class: CarRobotS3Application.tk

### Uses Technologies
* Kotlin
* Amazon S3
* Spring Batch
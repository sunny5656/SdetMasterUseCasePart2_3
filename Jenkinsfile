pipeline {
    agent any
	environment {JAVA_HOME = "C:\Program Files\Java\jdk-11"}
    stages {
        stage('Clean') {
            steps {
                dir("Ravikanti-Tharun-RestfulAndSoapWS2") {
		bat "mvn clean"
	}
            }
        }
        stage('Compile') {
            steps {
	dir("Ravikanti-Tharun-RestfulAndSoapWS2") {
		bat "mvn compile"
	}
            }
        }
        stage('Test') {
            steps {
	dir("Ravikanti-Tharun-RestfulAndSoapWS2") {
		bat "mvn test"
	}
            }
        }
        stage('Result') {
            steps {
                echo "Result"
            }
        }
    }
}

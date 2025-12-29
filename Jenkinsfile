pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps { sh 'mvn clean compile' }
        }
        stage('Run Tests') {
            steps { sh 'mvn test' }
        }
        stage('Publish Reports') {
            steps { allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] }
        }
    }
}
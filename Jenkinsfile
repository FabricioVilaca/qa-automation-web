pipeline {
    agent { label 'local' }

    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9'
    }

    environment {
        HEADLESS = 'true'
        APP_CREDENTIALS = credentials('app-credentials')
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -Dheadless=%HEADLESS% -Dapp.user=%APP_CREDENTIALS_USR% -Dapp.password=%APP_CREDENTIALS_PSW%'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo 'Tests passed'
        }
        failure {
            echo 'Tests failed'
        }
    }
}
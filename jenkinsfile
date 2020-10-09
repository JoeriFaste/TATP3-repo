pipeline {
    agent any

    stages {
        stage ('Compile stage'){
            steps {
                    bat 'mvn clean compile'
            }
        }
        stage ('Testing stage'){
            steps {
                    bat 'mvn test'
            }
        }
        stage ('Reporting Stage'){
            steps {
                 script {
                       allure([
                            includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                       ])
                 }
            }
        }
    }
}
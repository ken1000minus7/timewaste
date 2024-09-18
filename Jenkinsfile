pipeline {
    agent any
    stages {
        stage('setup') {
            steps {
                script {
                    build job: 'setup'
                }
            }
        }
        stage('compile') {
            steps {
                script {
                    build job: 'compile'
                }
            }
        }
        stage('Unit Testing') {
            steps {
                script {
                    build job: 'unit-test'
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                script {
                    build job: 'coverage'
                }
            }
        }
        stage('Static Code Analysis') {
            steps {
                script {
                    build job: 'sonar'
                }
            }
        }
        stage('Build WAR') {
            steps {
                script {
                    build job: 'war'
                }
            }
        }
        stage('Push to artifactory') {
            steps {
                script {
                    build job: 'deploy'
                }
            }
        }
        stage('Deploy to tomcat') {
            steps {
                script {
                    build job: 'smoke-test'
                }
            }
        }
    }
}

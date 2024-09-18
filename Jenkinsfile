pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('setup') {
            steps {
                script {
                    def result = build job: 'setup'
                    log = Jenkins.getInstance().getItemByFullName('setup').getBuildByNumber(result.getNumber()).logFile.text
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

pipeline {
    agent any
    tools {
            maven 'maven'
            jdk 'java'
    }
    stages {

        stage ('Build Image'){
            steps{
                script {
                    if (isUnix()) {
                        sh 'docker build -t play -f ./Dockerfile .'
                    } else {
                        bat 'docker build -t play -f ./Dockerfile .'
                    }
                }
            }
        }

        stage ('Start Playwright Grid'){
            steps{
                script {
                    if (isUnix()) {
                        sh 'docker run play:latest mvn test "-Dcucumber.options=--tags ''" -Denv=des'
                    } else {
                        bat 'docker run play:latest mvn test "-Dcucumber.options=--tags ''" -Denv=des'
                    }
                }
            }
        }
        stage ('Run Tests'){
			steps{
				script {
					if (isUnix()) {
						sh 'mvn clean test -Denv=des -Dbrowser=chrome -Dheadless=false'
					} else {
						bat 'mvn clean test -Denv=des -Dbrowser=chrome -Dheadless=false'
					}
				}
			}
        }

        stage ('Generate Allure Reports'){
            steps{
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

        stage ('Stop Docker'){
            steps{
                script {
                    if (isUnix()) {
                            sh 'docker stop'
                        } else {
                            bat 'docker stop'
                    }
                 }
            }
        }
     }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/xml-junit/*.xml'
            archiveArtifacts artifacts: 'target/log/*.log'
        }
    }
}
pipeline {
    agent any
    options {
        buildDiscarder logRotator(daysToKeepStr: '5', numToKeepStr: '10')
    }
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn -f my-app/pom.xml clean compile"
            }
        }
        stage('Test') { 
            steps {
                sh "mvn -f my-app/pom.xml test site"
            }
            
             post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'   
                }
            }     
        }

        stage('deploy') { 
            steps {
                sh "mvn -f my-app/pom.xml package"
            }
        }
        stage('SonarQube analysis')  {
            steps {
                 withSonarQubeEnv('sonarqube-8.9.6') {
                   sh 'mvn sonar:sonar'
                 }
           }
        }
        stage('Build Docker image'){
            steps {
                sh 'docker build -t aishwaryamalviya/maven-hello-world_master:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){

            steps {
                 withCredentials([string(credentialsId: 'DockerID', variable: 'Dockerpwd')]) {
                   sh "docker login -u aishwaryamalviya -p ${Dockerpwd}"
                }
            }
        }

        stage('Docker Push'){
            steps {
                sh 'docker push aishwaryamalviya/maven-hello-world_master:${BUILD_NUMBER}'
            }
        }

        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
        
    }
}

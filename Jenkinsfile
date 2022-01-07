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
        
        stage('deploy') { 
            steps {
                sh "mvn -f my-app/pom.xml package"
            }
        }
         stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
        stage('SonarQube analysis')  {
            steps {
                 withSonarQubeEnv('sonarqube-8.9.6') {
                   sh 'mvn -f my-app/pom.xml sonar:sonar'
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

       
        
    }
}

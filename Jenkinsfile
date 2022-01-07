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
        
    }
}

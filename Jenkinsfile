@Library('share-library') _
pipeline {
    agent any 
    stages {
        stage('Example Build') {
            steps {
                sh 'Hello Word!!'
            }
        }
        stage('Build') {
            agent{
                label 'nodo-vm'
            }
            steps {
                script{
                    build.build(profile:"dev")
                }
            }
        }
    }
}
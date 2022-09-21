pipeline {
    agent any 
    stages {
        stage('Example Build') {
            steps {
                echo "Hello Word"
            }
        }
        stage('Build') {
            steps {
                script{
                     
                    JENKINS_FILE = readJSON file: 'Jenkinsfile.json';
                    def argCore = JENKINS_FILE[BRANCH_NAME]
                    for( int i = 0; i < argCore.size(); i++ ) {
                        def arg = argCore[i].keySet();
                        sh "$arg"
                    }
                }
            }
        }
    }
}
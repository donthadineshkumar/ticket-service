pipeline {
    agent  any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                /*sh 'mvn --version'
                sh 'echo "Hello World"'
                timeout(time: 3, unit: 'MINUTES'){
                    sh 'mvn clean package'
                }
                retry(3){
                    sh 'echo "ITS DONE!!!"'
                }*/
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    post {
        success {
            echo 'Build is successful'
        }
        failure {
            echo 'Build is failed'
        }
    }
}
#declarative pipeline
pipeline {
    agent { docker { image 'maven:3.3.3' }  }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'echo "Hello World"'
                timeout(time: 3, unit: 'MINUTES'){
                    sh 'mvn clean package'
                }
                retry(3){
                    sh 'echo "ITS DONE!!!"'
                }
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
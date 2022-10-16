pipeline {
    agent { label 'SHOPIZER' }                  
    stages {
        stage('vcs') {
            steps {
                git branch: 'develop',
                       url: 'https://github.com/maheshryali/shopizer.git'
            }
        }
        stage('maven build') {
            steps {
                sh ("mvn package")
                }
        }
        stage( 'artifacts') {
            steps{
            junits '**/surefire-reports/*.xml'
            }
        }
    }
     triggers { cron('30 17 * * *') }
}

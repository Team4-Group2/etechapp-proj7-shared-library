def call(String repoUrl){
pipeline{
    agent any
    stages{
        stage('1-EngEkong'){
            steps{
                sh 'ps -ef'
                sh 'free -g'
            }
        }
        stage('2-EngAnakua'){
            steps{
                sh 'lscpu'
            }
        }
        stage('3-Checkout Code'){
            steps {
                git branch: 'main',
                        url: "${repoUrl}"
            }
        }
        stage('4-EngEkop'){
            steps{
                sh 'df -h'
            }     
        }
        stage('5-EngBabatola'){
            steps{
                echo 'Welcome to Babatola App'
            }
        }
    }
}
}
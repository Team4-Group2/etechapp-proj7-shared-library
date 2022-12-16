def call(String repoUrl){
pipeline {
       agent any
       stages{
           stage('1-Parallel'){
                parallel{
                    stage('1-1 Tools initialization') {
                        steps {
                            sh 'lscpu'
                            sh 'free -g'
                            sh 'java -version'
                        }
                    }
                    stage('1-2 Checkout Code') {
                        steps {
                            git branch: 'main',
                                    url: "${repoUrl}"
                        }
                    }
                }
            }
            stage('2-Send Message') {
               steps {
                   echo 'Welcome to Etechapp team'
               }
           }
       }
}
}
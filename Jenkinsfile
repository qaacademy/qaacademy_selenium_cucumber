pipeline {
    agent any
   //
    stages {
        stage('Testes Unitarios') {
            steps {
                // Download do projeto de teste unitario
                sh 'echo Inicio dos testes unitarios Baixando projeto qaacademy_exercicios_junit.git'
                git 'https://github.com/qaacademy/qaacademy_exercicios_junit.git'

                // Executar os testes unitarios usando Maven
                sh "mvn clean install test"

            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Build BugBank') {
                    steps {
                        // Download do projeto de teste unitario
                        sh 'echo Baixando projeto BugBank'
                        git branch: 'main', url: 'https://github.com/qaacademy/bugbank.git'
                        // Executar os testes unitarios usando Maven
                        sh "nohup ./run.sh &"

                    }

        }
        stage('Run e2e test') {
                            steps {
                                // Download do projeto de teste unitario
                                sh 'echo Baixando projeto test'
                                git 'https://github.com/qaacademy/qaacademy_selenium_cucumber.git'
                                sh 'mvn clean install -Dtest=Runner test'
                            }

                }
    }
}
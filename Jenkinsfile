pipeline {
    agent any
   //
    stages {
        stage('Testes Unitarios') {
            steps {
                // Download do projeto de teste unitario
                bat 'echo Inicio dos testes unitarios Baixando projeto qaacademy_exercicios_junit.git'
                git 'https://github.com/gupereirah/qaacademy_exercicios_junit-1.git'

                // Executar os testes unitarios usando Maven
                bat "mvn clean install test"

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
        stage('Build Bugbank') {
                    steps {
                        // Download do projeto de teste unitario
                        bat 'echo Baixando Bugbank'
                        git 'https://github.com/qaacademy/bugbank.git'
                        bat 'yarn'
                        bat 'echo Bugbank está em execução'

                    }
        }

    }
}
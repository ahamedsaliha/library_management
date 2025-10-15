pipeline {
    agent any

    tools {
        jdk 'JDK19'        // Make sure JDK19 is configured in Jenkins Global Tool Configuration
        maven 'Maven3'     // Make sure Maven3 is configured in Jenkins
    }

    environment {
        APP_NAME = 'library-management'
        DEPLOY_DIR = 'C:\\Users\\Ahamed Saliha\\.jenkins\\deployments'
    }

    stages {

        stage('Checkout') {
            steps {
                echo '📦 Cloning repository...'
                git branch: 'main', url: 'https://github.com/ahamedsaliha/library_management.git'
            }
        }

        stage('Build') {
            steps {
                echo '🔨 Building project...'
                bat 'mvn -B clean package'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                bat 'mvn -B test'
            }
        }

        stage('Package') {
            steps {
                echo '🎁 Preparing artifact...'
                bat 'dir target'
            }
        }

        

        stage('Deploy') {
            steps {
                echo '🚀 Deploying application...'
                bat """
                if not exist "%DEPLOY_DIR%" mkdir "%DEPLOY_DIR%"
                copy target\\*.jar "%DEPLOY_DIR%"
                """
            }
        }

        
    }

    post {
        success {
            echo '✅ Build and deployment successful!'
        }
        failure {
            echo '❌ Build failed. Check console output for errors.'
        }
    }
}

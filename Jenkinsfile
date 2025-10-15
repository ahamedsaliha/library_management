pipeline {
    agent any

    tools {
        jdk 'JDK17'        
        maven 'Maven3'     
    }

    stages {
        stage('Checkout') {
            steps {
                echo '📦 Cloning repository...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '🔨 Building project...'
                sh 'mvn -B clean package'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                sh 'mvn -B test'
            }
        }

        stage('Package Jar') {
            steps {
                echo '🎁 Creating JAR file...'
                sh 'ls target'
            }
        }

        stage('Docker Build') {
            steps {
                echo '🐳 Building Docker image...'
                sh 'docker build -t library-management:${BUILD_NUMBER} .'
            }
        }

        stage('Run Container') {
            steps {
                echo '🚀 Running container...'
                sh '''
                    docker stop library || true
                    docker rm library || true
                    docker run -d --name library -p 8080:8080 library-management:${BUILD_NUMBER}
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build successful and container running!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}

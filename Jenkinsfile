pipeline {
    agent any

    tools {
        jdk 'JDK19'        
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
                bat 'mvn -B clean package'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                bat 'mvn -B test'
            }
        }

        stage('Package Jar') {
            steps {
                echo '🎁 Creating JAR file...'
                bat 'dir target'
            }
        }

        stage('Docker Build') {
            steps {
             echo '🐳 Building Docker image...'
             bat "docker build -t library-management:%BUILD_NUMBER% ."
         }
      }

        stage('Run Container') {
          steps {
           echo '🚀 Running container...'
           bat '''
           docker stop library || exit 0
           docker rm library || exit 0
          docker run -d --name library -p 8080:8080 library-management:%BUILD_NUMBER%
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

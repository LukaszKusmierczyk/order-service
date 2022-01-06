@Library("shared-library") _


pipeline {
	agent any

	stages {
		stage('checkout') {
			steps {
				git url: 'https://github.com/LukaszKusmierczyk/order-service.git', branch: 'main'
			}
		}
        stage('build') {
            steps {
                sh './gradlew clean build'
            }

            //post {
            //    always {
            //        junit 'build/test-results/test/*.xml'
            //    }
            //}
        }
        stage('create docker image') {
            steps {
                script {
                    docker.withRegistry('https://lkusmierczyk.jfrog.io', 'artifactory-credentials') {

                        def customImage = docker.build("lkusmierczyk.jfrog.io/order-service-docker/order-service:${env.BUILD_ID}")

                        /* Push the container to the custom Registry */
                        customImage.push()
                    }
                }

            }
        }
	}
}

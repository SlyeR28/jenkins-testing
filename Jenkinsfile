pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out source code from repository...'
                checkout scm
            }
        }

        stage('Build & Package WAR') {
            steps {
                echo 'Building Java Web Application WAR package...'
                // Build the war artifact using Maven wrapper or mvn
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Archive Artifact') {
            steps {
                echo 'Archiving target/javawebapp.war...'
                archiveArtifacts artifacts: 'target/javawebapp.war', allowEmptyArchive: false
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying javawebapp.war to Apache Tomcat webapps...'
                script {
                    /*
                     * Path where Apache Tomcat is installed on your Ubuntu VM.
                     * Common locations:
                     * 1. /opt/tomcat/webapps
                     * 2. /var/lib/tomcat9/webapps or /var/lib/tomcat10/webapps
                     * 3. /usr/local/tomcat/webapps (Docker)
                     */
                    def tomcatPaths = [
                        '/opt/tomcat/webapps',
                        '/var/lib/tomcat9/webapps',
                        '/var/lib/tomcat10/webapps',
                        '/usr/local/tomcat/webapps'
                    ]
                    
                    def deployed = false
                    for (path in tomcatPaths) {
                        def pathExists = sh(script: "[ -d ${path} ]", returnStatus: true) == 0
                        if (pathExists) {
                            sh "cp target/javawebapp.war ${path}/"
                            echo "Successfully deployed target/javawebapp.war to ${path}/"
                            deployed = true
                            break
                        }
                    }
                    
                    if (!deployed) {
                        echo "WARNING: Could not auto-detect Tomcat webapps folder. Copy target/javawebapp.war manually to your Tomcat webapps directory."
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline Completed Successfully!'
            echo 'Access your application at: http://localhost:8080/javawebapp/'
        }
        failure {
            echo 'Pipeline execution failed. Check console output for details.'
        }
    }
}

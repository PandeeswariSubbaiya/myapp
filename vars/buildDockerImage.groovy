#!/usr/bin/env groovy

def call(String imageName){
    echo "Building Docker image..."
    //withCredentials([usernamePassword(credentialsId: "dockerhub-credentials", usernameVariable: "username", passwordVariable: "password")]){
      withCredentials([string(credentialsId: 'dockerPass', variable: 'dockerPassword')]) {
        sh "docker build -t $imageName ."
        sh "echo $password | docker login -u $username --password-stdin"
        sh "docker push $imageName"
    }
}

#!/usr/bin/env groovy

def call(String imageName){
    echo "Building Docker image..."
    withCredentials([usernamePassword(credentialsId: "dockerlibrary", usernameVariable: "username", passwordVariable: "password")]){
        sh "docker build -t $imageName ."
        sh "echo $password | docker login -u $username --password-stdin"
        //sh "echo $password | docker login -u pandeeswari1814 --password-Subbaiya@08
        sh "docker push $imageName"
    }
}

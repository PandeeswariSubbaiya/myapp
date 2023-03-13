def call(String project, String hubUser) {
    sh "docker image build -t ${hubUser}/${project} ."
    sh "docker tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}"
    sh "docker tag ${hubUser}/${project} ${hubUser}/${project}:latest"
    //withCredentials([usernamePassword(
            //credentialsId: "dockerlibrary",
            //usernameVariable: "USER",
            //passwordVariable: "PASS"
   // )]) 
     withCredentials([string(credentialsId: 'dockerlibrary', variable: 'dockerPassword')]) {
        sh "docker login -u pandeeswari1814 -p ${dockerPassword}"
    }
    sh "docker image push ${hubUser}/${project}:${ImageTag}"
    sh "docker image push ${hubUser}/${project}:latest"
}

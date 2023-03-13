def call(String groupId, String artifactId, String version, String packaging, String file, String repositoryUrl, String repositoryUsername, String repositoryPassword) {
    def nexusUrl = repositoryUrl + "/repository"
    def nexusAuth = "${repositoryUsername}:${repositoryPassword}"
    def nexusArtifactPath = "${groupId.replaceAll("\\.", "/")}/${artifactId}/${version}/${artifactId}-${version}.${packaging}"
    def nexusUploadUrl = "${nexusUrl}/maven-releases/${nexusArtifactPath}"
    
    sh "curl --fail --silent --show-error --upload-file ${file} -u ${nexusAuth} ${nexusUploadUrl}"
}

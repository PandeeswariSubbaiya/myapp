def call(String groupId, String artifactId, String version, String packaging, String file, String repositoryUrl, String repositoryUsername, String repositoryPassword) {
    new com.mycompany.jenkins.sharedlibrary.Nexus().upload(groupId, artifactId, version, packaging, file, repositoryUrl, repositoryUsername, repositoryPassword)
}

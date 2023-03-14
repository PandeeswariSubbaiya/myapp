def call(String groupId, String artifactId, String version, String packaging, String repositoryUrl, String username, String password, String file) {
    def server = new org.apache.maven.artifact.ant.RemoteRepository()
    server.setUrl(repositoryUrl)
    server.setId("nexus")
    server.setUsername(username)
    server.setPassword(password)
    def pom = new XmlSlurper().parseText("""
            4.0.0
            ${groupId}
            ${artifactId}
            ${version}
            ${packaging}
    """)
    def deployer = new org.apache.maven.artifact.deployer.DefaultArtifactDeployer()
    def artifact = new org.apache.maven.artifact.DefaultArtifact(groupId, artifactId, version, "compile", packaging, null, new org.apache.maven.artifact.handler.DefaultArtifactHandler(packaging))
    artifact.setFile(new java.io.File(file))
    deployer.setRepository(server)
    deployer.deploy(artifact, pom, server, null)
}

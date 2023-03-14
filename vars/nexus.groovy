def publishToNexus(String repositoryUrl, String groupId, String artifactId, String version, File artifactFile) {
  def nexus = new NexusRepository(repositoryUrl)
  nexus.authenticate('username', 'password')
  nexus.uploadMaven(groupId, artifactId, version, artifactFile)
}

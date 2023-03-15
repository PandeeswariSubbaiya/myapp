def call(Map config) {
    def qualityGateUrl = "${config.sonarqube_url}"
    def qualityGateResult = sh (
        script: "curl -s -u ${config.sonarqube_token}: ${qualityGateUrl}" ,
        returnStdout: true
    ).trim()
    
    if (qualityGateResult != 'OK') {
        error "Quality gate failed: ${qualityGateResult}"
    }
}

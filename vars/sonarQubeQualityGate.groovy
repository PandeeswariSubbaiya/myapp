def call(Map config) {
    def qualityGateUrl = "${config.sonarqube_url}/api/qualitygates/project_status?projectKey=${config.project_key}"
    def qualityGateResult = sh (
        script: "curl -s -u ${config.sonarqube_token}: ${qualityGateUrl} | jq -r .projectStatus.status",
        returnStdout: true
    ).trim()
    
    if (qualityGateResult != 'OK') {
        error "Quality gate failed: ${qualityGateResult}"
    }
    
    // Quality gate passed, do something
    echo "Quality gate passed!"
}

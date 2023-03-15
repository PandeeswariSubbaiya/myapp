def plan(Map config) {
    sh """
    cd terraform
    terraform plan -out=tfplan
    """
}

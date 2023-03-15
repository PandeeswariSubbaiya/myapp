def call(Map config) {
    sh """
    cd terraform
    terraform plan -out=tfplan
    """
}

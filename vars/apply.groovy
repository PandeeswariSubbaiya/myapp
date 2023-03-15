def call(Map config) {
    sh """
    cd terraform
    terraform apply -auto-approve tfplan
    """
}

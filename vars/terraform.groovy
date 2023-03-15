def init(Map config) {
    sh """
    mkdir -p terraform
    cp ${config.ec2_file} terraform/ec2.tf
    cp ${config.provider_file} terraform/provider.tf
    cd terraform
    terraform init
    """
}

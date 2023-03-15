//def call(Map config) {
        //sh """
            //terraform init -input=false ${config.tf_init_args}
            //terraform plan -input=false ${config.tf_plan_args}
            //terraform apply -input=false ${config.tf_apply_args}
        //"""
    //}
//}
def init(Map config) {
    sh """
    mkdir -p terraform
    cp ${config.ec2_file} terraform/ec2.tf
    cp ${config.provider_file} terraform/provider.tf
    cd terraform
    terraform init
    """
}

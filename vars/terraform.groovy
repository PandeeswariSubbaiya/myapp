def call(Map config) {
    dir("${config.workspace}") {
        sh """
            terraform init -input=false ${config.tf_init_args}
            terraform plan -input=false ${config.tf_plan_args}
            terraform apply -input=false ${config.tf_apply_args}
        """
    }
}

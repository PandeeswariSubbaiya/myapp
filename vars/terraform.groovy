def call(Map config) {
    sh "terraform init -backend-config=${config.backend_config_file}"
    //sh "terraform plan -var-file=${config.var_file}"
    //sh "terraform apply -var-file=${config.var_file}"
}

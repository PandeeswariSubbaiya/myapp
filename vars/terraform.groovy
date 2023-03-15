#!/bin/bash
def call(Map config) {
        sh """
            //terraform init -input=false ${config.tf_init_args}
            //terraform plan -input=false ${config.tf_plan_args}
            //terraform apply -input=false ${config.tf_apply_args}
            terraform init -reconfigure
            terraform plan -lock=false
            terraform apply -lock=false -auto-approve
        """
    }
}

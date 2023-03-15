#!/bin/bash
def call(Map config) {
        sh """
            //terraform init -input=false ${config.tf_init_args}
            //terraform plan -input=false ${config.tf_plan_args}
            //terraform apply -input=false ${config.tf_apply_args}
            terraform init -reconfigure ${config.tf_init_args}
            terraform plan -lock=false ${config.tf_plan_args}
            terraform apply -lock=false -auto-approve ${config.tf_apply_args}
        """
    }
}

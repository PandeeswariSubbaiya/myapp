def call() {
    def vars = [:]
    def varFiles = sh(script: 'ls vars/*.tfvars', returnStdout: true).trim().split("\n")
    for (int i = 0; i < varFiles.size(); i++) {
        def varFile = varFiles[i]
        def varName = varFile.substring(varFile.lastIndexOf('/') + 1, varFile.lastIndexOf('.'))
        vars[varName] = readProperties file: varFile
    }
    return vars
}

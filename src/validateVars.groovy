def call(Map vars) {
    def missingVars = []
    for (def var in ['foo', 'bar', 'baz']) {
        if (!vars[var]) {
            missingVars.add(var)
        }
    }
    if (missingVars) {
        error "The following required variables are missing: ${missingVars.join(', ')}"
    }
}

def call() {
    def vars = library.loadVars()
    assert vars.foo == 'fooValue'
    assert vars.bar == 'barValue'
    assert vars.baz == 'bazValue'
}

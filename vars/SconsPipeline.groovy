import org.jenkinsci.plugins.docker.workflow.*
import org.jenkinsci.plugins.workflow.cps.CpsScript


static builder(script, DSL steps) {
    // create the image to use in this build instead of using a parameter
    def docker script.getClass().getClassLoader().loadClass("org.jenkinsci.plugins.docker.workflow.Docker").getConstructor(CpsScript.class).newInstance(script);
    image = docker.image("pandeeswari1814/native-scons")
    return new Builder(script, steps, image)
}

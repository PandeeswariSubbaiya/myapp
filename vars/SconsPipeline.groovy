// I hoped it would import `Docker`
import org.jenkinsci.plugins.docker.workflow.*

class SConsPipeline implements Serializable {

    def script
    def stages
    def image
    DSL steps

    static builder(script, DSL steps) {
        // create the image to use in this build instead of using a parameter
        def docker = Docker(script)
        image = docker.image("pandeeswari/native-scons")
        return new Builder(script, steps, image)
    }

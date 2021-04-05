import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call(String name, Boolean expr, Closure body) {
    stage(name) {
        if (expr) {
            body.call()
        } else {
            Utils.markStageSkippedForConditional(name)
        }
    }
}
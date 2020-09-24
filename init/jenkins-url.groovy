import jenkins.model.JenkinsLocationConfiguration
jlc = JenkinsLocationConfiguration.get()
jlc.setUrl(System.getenv("JENKINS_URL"))
jlc.save()

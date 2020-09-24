#!groovy

import jenkins.model.*
import hudson.security.*
import hudson.security.csrf.*


def jenkins = Jenkins.getInstance()

// Enable CSRF protection
jenkins.setCrumbIssuer(new DefaultCrumbIssuer(true))

// Disable CLI over the remoting protocol for security
//jenkins.getDescriptor("jenkins.CLI").get().enabled = false

// Disable old/unsafe agent protocols for security
jenkins.agentProtocols = ["JNLP4-connect", "Ping"] as Set

// disabled CLI access over TCP listener (separate port)
def p = jenkins.AgentProtocol.all()
p.each { x ->
    if (x.name?.contains("CLI")) {
        println "Removing protocol ${x.name}"
        p.remove(x)
    }
}

// disable CLI access over /cli URL
def removal = { lst ->
    lst.each { x ->
        if (x.getClass().name.contains("CLIAction")) {
            println "Removing extension ${x.getClass().name}"
            lst.remove(x)
        }
    }
}

jenkins.save()

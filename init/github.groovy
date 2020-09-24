import org.jenkinsci.plugins.github_branch_source.*

// http://jenkins-ci.361315.n4.nabble.com/JIRA-JENKINS-54019-programatically-add-GitHub-Enterprise-Servers-in-Jenkins-td4950426.html

Endpoint endpoint = new Endpoint("http://test.com", "test")
GitHubConfiguration ghc = new GitHubConfiguration()
ghc.addEndpoint(endpoint)

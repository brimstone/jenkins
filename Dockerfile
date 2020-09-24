FROM jenkins/jenkins:lts-slim

RUN /usr/local/bin/install-plugins.sh github-branch-source docker-workflow matrix-auth \
	dockerhub-notification docker

ENV JENKINS_USER admin
ENV JENKINS_PASS admin

ENV JENKINS_URL http://localhost:8080/

# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY init/*.groovy /usr/share/jenkins/ref/init.groovy.d/

USER root
RUN echo 'docker:x:997:jenkins' >> /etc/group
USER jenkins

VOLUME /var/jenkins_home

# Jenkins

This is a docker image that runs builds in docker, in kvm, in a container.
It's basically turtles all the way down.

## Usage
```
docker run --rm -it --net host --name jenkins \
-v /var/run/docker.sock:/var/run/docker.sock \
-e JENKINS_URL="http://192.168.0.100:8080" \
brimstone/jenkins
```

## TODO
- [ ] Make docker agents use websocket and not JNLP port
- [ ] Use a github token and automatically build everything it can.
- [ ] Prevent a big build storm at start
- [ ] Figure out a better way to allow jenkins to write to the docker socket when mounted from the host.

## Resources
https://gist.github.com/johnbuhay/c6213d3d12c8f848a385
https://github.com/jenkinsci/configuration-as-code-plugin

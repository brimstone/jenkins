.PHONY: build
build:
	docker build -t brimstone/jenkins:agent .
	-docker rm -vf kvm

.PHONY: test
test:
	docker run -v /sys:/sys --rm -it --privileged --name kvm --device /dev/kvm -v /lib/modules:/lib/modules:ro brimstone/jenkins:agent
.PHONY: test-loop
test-loop:
	while true; do make test; sleep 2; done

.PHONY: watch
watch:
	find . -type f | entr make

.PHONY: push
push: build
	docker push brimstone/jenkins:agent

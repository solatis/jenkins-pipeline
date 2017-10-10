#!/usr/bin/groovy
def call(Map parameters = [:], body) {
  def label = parameters.get('label', 'docker')
  podTemplate(
    label: label,
    containers: [containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true)],
    volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]) {
    body()
  }
}

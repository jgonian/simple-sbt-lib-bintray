//
// Use sbt-maven-resolver auto plugin, which internally uses Eclipse Aether to resolve Maven dependencies
// instead of Apache Ivy. Aether is the same library as maven itself uses, meaning that the same behaviour
// should be expected including construction of maven-metadata.xml files when publishing to remote repositories
// or when publishing to the local ~/.m2/repository.
//
// This is necessary for Slater as the metadata file is how plugins like versions-maven-plugin and sbt-updates
// determine the latest release versions.
//
addMavenResolverPlugin

.PHONY : install compile package run

install:
	brew install protobuf
	brew tap ktr0731/evans
	brew install evans

clean:
	mvn clean

compile:
	mvn compile

package:
	mvn package

run: | clean package
	mvn compile exec:java

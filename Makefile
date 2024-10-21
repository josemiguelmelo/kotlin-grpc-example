.PHONY : install compile package run

install:
	brew install protobuf
	brew tap ktr0731/evans
	brew install evans
	go install "github.com/pseudomuto/protoc-gen-doc/cmd/protoc-gen-doc@latest"
	pip install sabledocs

protoc-gendocs:
	mkdir -p ./src/main/proto/docs
	protoc --doc_out=./src/main/proto/docs --doc_opt=html,index.html ./src/main/proto/*.proto

sabledocs-gendocs:
	cd ./src/main/proto; \
	protoc *.proto -o descriptor.pb --include_source_info; \
	sabledocs

clean:
	mvn clean

compile:
	mvn compile

package:
	mvn package

run: | clean package
	mvn compile exec:java

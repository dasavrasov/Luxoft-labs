.DEFAULT_GOAL := build-run

build-run: build run

run:
	java -jar ./target/spring-course10-1.0-SNAPSHOT-jar-with-dependencies.jar

clean:
	rm -rf ./target

build:
	./mvnw clean package

update:
	./mvnw versions:update-properties versions:display-plugin-updates

README.md

1. This is a sample dockerized Spring Boot Application.
2. To run the sample code, do the following:
	a. Go to the directory which contains the Dockerfile
	b. Run thw following commands in the terminal/command line
		i. mvn clean install
		i. docker build -t hello-world .
		ii. docker run -p 8080:8080 hello-world
	c. Go to http://localhost:8080/ in your browser to view it.
<ol>
<li>
<p>This is a sample dockerized Spring Boot Application.</p>
</li>
<li>
<p>To run the sample code, do the following:</p>
<ol>
<li>Go to the directory which contains the Dockerfile</li>
<li>Run the following commands in the terminal/command line:
<ol>
<li>mvn clean install&nbsp;</li>
<li>docker build -t hello-world .</li>
<li>docker run -p 8080:8080 hello-world</li>
</ol>
</li>
<li>Go to http://localhost:8080/ in your browser to view it.</li>
</ol>
</li>
</ol>

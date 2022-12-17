
## Description
Sample poc project to give an api to call, general lorem text and serve images.


### active urls
http://localhost/swagger-ui/

http://localhost/v2/api-docs

http://localhost/api/status

http://localhost/api/get?w=Portal%20is%20Great

http://localhost/api/get?w=Portal%20is%20Great&wc=20

http://localhost/

http://localhost/test.html

### run gradle :-
- bootRun
- bootJar

### docker
docker build palash4242/lorem:v2 .

docker run -p 80:80 palash4242/lorem:v2
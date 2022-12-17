FROM adoptopenjdk/openjdk15:jre-15.0.2_7
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build/libs/*.jar app.jar
EXPOSE 60600
CMD ["java", "-jar", "app.jar"]
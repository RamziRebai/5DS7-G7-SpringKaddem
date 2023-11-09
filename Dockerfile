FROM openjdk:8
EXPOSE 8080
ADD target/ramzirebai-5ds7-g7-springkaddem.jar ramzirebai-5ds7-g7-springkaddem.jar
ENTRYPOINT ["java","-jar","/ramzirebai-5ds7-g7-springkaddem.jar"]
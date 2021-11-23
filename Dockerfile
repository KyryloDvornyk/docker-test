#FROM openjdk:11 as build
#WORKDIR /workspace/app
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src
#
#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
#FROM openjdk:11
#VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.dockertest.DockerTestApplication"]

#FROM openjdk:11 as builder
#COPY . /build
#WORKDIR /build
#RUN ./mvnw install
#WORKDIR /build/build/libs
#RUN java -Djarmode=layertools -jar app.jar extract
#
#FROM openjdk:11
#WORKDIR /application
#COPY --from=builder /build/build/libs/dependencies/ ./
#COPY --from=builder /build/build/libs/spring-boot-loader/ ./
#COPY --from=builder /build/build/libs/snapshot-dependencies/ ./
#COPY --from=builder /build/build/libs/application/ ./
#EXPOSE 8080
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/application.jar"]
export LS_ACCESS_TOKEN=0HaVlTbt0k81dMks0bdPufuvpWAGPrWuLi4ax54vkmpeAQnqMarBQ0jLEEMHND3oYYv4dVjViM6NXUZ1lYS1xLB6B4IG7RQ3Kjq4csIr
export LS_SERVICE_NAME=fiu-prod-db5e0afc
java -javaagent:"./target/lightstep-opentelemetry-javaagent.jar" \
     -jar target/*.jar
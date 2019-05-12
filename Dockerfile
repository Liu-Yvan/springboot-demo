FROM openjdk:8-jdk

MAINTAINER test@example.com

ARG JAR_FILE
ARG JAR_PATH="/apps/jars/app.jar"

ENV JAR_PATH $JAR_PATH
ENV JAVA_OPTS "-server -Xms256M -Xmx1024M -Xss1M -XX:MinHeapFreeRatio=30 -XX:MaxHeapFreeRatio=50 -XX:MaxMetaspaceSize=256M -XX:MinMetaspaceFreeRatio=20 -XX:MaxMetaspaceFreeRatio=30 -Duser.timezone=GMT+08"

ADD target/${JAR_FILE} $JAR_PATH

RUN mkdir -p /apps/bin
COPY start.sh /apps/bin/start.sh

#make the start.sh executable 
RUN chmod 777 /apps/bin/start.sh

ENTRYPOINT ["/apps/bin/start.sh"]


#EXPOSE 80
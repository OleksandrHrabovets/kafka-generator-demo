package com.example.kafkageneratordemo.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

@Configuration
public class KafkaConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  String servers;

  @Value("${spring.kafka.producer.key-serializer}")
  String keySerializer;

  @Value("${spring.kafka.producer.value-serializer}")
  String valueSerializer;


  @Bean
  SenderOptions<String, Object> senderOptions() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
    return SenderOptions.create(props);
  }

  @Bean
  public KafkaSender<String, Object> kafkaSender(SenderOptions<String, Object> senderOptions) {
    return KafkaSender.create(senderOptions);
  }

  @Bean
  public NewTopic temperatureTopic() {
    return TopicBuilder.name("data-temperature")
        .partitions(5)
        .replicas(1)
        .config(
            TopicConfig.RETENTION_MS_CONFIG,
            String.valueOf(Duration.ofDays(7).toMillis())
        )
        .build();
  }

  @Bean
  public NewTopic voltageTopic() {
    return TopicBuilder.name("data-voltage")
        .partitions(5)
        .replicas(1)
        .config(
            TopicConfig.RETENTION_MS_CONFIG,
            String.valueOf(Duration.ofDays(7).toMillis())
        )
        .build();
  }

  @Bean
  public NewTopic powerTopic() {
    return TopicBuilder.name("data-power")
        .partitions(5)
        .replicas(1)
        .config(
            TopicConfig.RETENTION_MS_CONFIG,
            String.valueOf(Duration.ofDays(7).toMillis())
        )
        .build();
  }
}

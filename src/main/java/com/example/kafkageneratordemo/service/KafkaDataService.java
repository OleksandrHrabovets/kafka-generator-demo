package com.example.kafkageneratordemo.service;

import com.example.kafkageneratordemo.model.Data;

public interface KafkaDataService {

  void send(Data data);

}

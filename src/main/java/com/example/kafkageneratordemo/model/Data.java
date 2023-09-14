package com.example.kafkageneratordemo.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Data {

  private Long sourceId;
  private LocalDateTime timestamp;
  private DataType type;
  private double value;

  public enum DataType {

    TEMPERATURE,
    VOLTAGE,
    POWER

  }

}

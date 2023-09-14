package com.example.kafkageneratordemo.web.dto;

import com.example.kafkageneratordemo.model.Data.DataType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataDto {

  private Long sourceId;
  private LocalDateTime timestamp;
  private DataType type;
  private double value;

}

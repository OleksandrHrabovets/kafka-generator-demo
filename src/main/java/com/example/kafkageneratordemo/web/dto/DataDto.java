package com.example.kafkageneratordemo.web.dto;

import com.example.kafkageneratordemo.model.Data.DataType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataDto {

  private Long sourceId;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime timestamp;
  private DataType type;
  private double value;

}

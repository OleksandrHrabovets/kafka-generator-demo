package com.example.kafkageneratordemo.web.mapper;

import com.example.kafkageneratordemo.model.Data;
import com.example.kafkageneratordemo.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {

}

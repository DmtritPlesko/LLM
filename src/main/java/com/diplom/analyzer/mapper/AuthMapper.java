package com.diplom.analyzer.mapper;

import com.diplom.analyzer.dto.response.AuthResponse;
import com.diplom.analyzer.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthMapper {

    AuthResponse toResponse(User user);
}

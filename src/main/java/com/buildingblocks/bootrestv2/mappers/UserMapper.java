package com.buildingblocks.bootrestv2.mappers;

import com.buildingblocks.bootrestv2.dtos.UserMsDto;
import com.buildingblocks.bootrestv2.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //User to UserMsDTO
    UserMsDto userToUserMsDto(User user);

    //List<User> to List<UserMsDTO>
    List<UserMsDto> userToUserDtos(List<User> users);
}

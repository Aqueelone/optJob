package ua.acceptic.optjob.service.mapper;

import ua.acceptic.optjob.domain.*;
import ua.acceptic.optjob.service.dto.BlackListDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BlackList and its DTO BlackListDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BlackListMapper extends EntityMapper<BlackListDTO, BlackList> {


    @Mapping(target = "publishers", ignore = true)
    BlackList toEntity(BlackListDTO blackListDTO);

    default BlackList fromId(Long id) {
        if (id == null) {
            return null;
        }
        BlackList blackList = new BlackList();
        blackList.setId(id);
        return blackList;
    }
}

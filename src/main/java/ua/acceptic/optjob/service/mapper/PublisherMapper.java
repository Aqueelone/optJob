package ua.acceptic.optjob.service.mapper;

import ua.acceptic.optjob.domain.*;
import ua.acceptic.optjob.service.dto.PublisherDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Publisher and its DTO PublisherDTO.
 */
@Mapper(componentModel = "spring", uses = {BlackListMapper.class})
public interface PublisherMapper extends EntityMapper<PublisherDTO, Publisher> {

    @Mapping(source = "blackList.id", target = "blackListId")
    PublisherDTO toDto(Publisher publisher);

    @Mapping(target = "campaignRecords", ignore = true)
    @Mapping(source = "blackListId", target = "blackList")
    Publisher toEntity(PublisherDTO publisherDTO);

    default Publisher fromId(Long id) {
        if (id == null) {
            return null;
        }
        Publisher publisher = new Publisher();
        publisher.setId(id);
        return publisher;
    }
}

package ua.acceptic.optjob.service.mapper;

import ua.acceptic.optjob.domain.*;
import ua.acceptic.optjob.service.dto.CampaignRecordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CampaignRecord and its DTO CampaignRecordDTO.
 */
@Mapper(componentModel = "spring", uses = {PublisherMapper.class, CampaignMapper.class})
public interface CampaignRecordMapper extends EntityMapper<CampaignRecordDTO, CampaignRecord> {

    @Mapping(source = "publisher.id", target = "publisherId")
    @Mapping(source = "campaign.id", target = "campaignId")
    CampaignRecordDTO toDto(CampaignRecord campaignRecord);

    @Mapping(source = "publisherId", target = "publisher")
    @Mapping(source = "campaignId", target = "campaign")
    CampaignRecord toEntity(CampaignRecordDTO campaignRecordDTO);

    default CampaignRecord fromId(Long id) {
        if (id == null) {
            return null;
        }
        CampaignRecord campaignRecord = new CampaignRecord();
        campaignRecord.setId(id);
        return campaignRecord;
    }
}

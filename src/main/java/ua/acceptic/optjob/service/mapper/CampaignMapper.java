package ua.acceptic.optjob.service.mapper;

import ua.acceptic.optjob.domain.*;
import ua.acceptic.optjob.service.dto.CampaignDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Campaign and its DTO CampaignDTO.
 */
@Mapper(componentModel = "spring", uses = {OptimizationPropsMapper.class, BlackListMapper.class})
public interface CampaignMapper extends EntityMapper<CampaignDTO, Campaign> {

    @Mapping(source = "optimizationProps.id", target = "optimizationPropsId")
    @Mapping(source = "blacklist.id", target = "blacklistId")
    CampaignDTO toDto(Campaign campaign);

    @Mapping(source = "optimizationPropsId", target = "optimizationProps")
    @Mapping(source = "blacklistId", target = "blacklist")
    @Mapping(target = "publishers", ignore = true)
    Campaign toEntity(CampaignDTO campaignDTO);

    default Campaign fromId(Long id) {
        if (id == null) {
            return null;
        }
        Campaign campaign = new Campaign();
        campaign.setId(id);
        return campaign;
    }
}

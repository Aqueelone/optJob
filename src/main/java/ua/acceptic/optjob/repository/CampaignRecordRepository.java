package ua.acceptic.optjob.repository;

import ua.acceptic.optjob.domain.CampaignRecord;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CampaignRecord entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CampaignRecordRepository extends JpaRepository<CampaignRecord, Long> {

}

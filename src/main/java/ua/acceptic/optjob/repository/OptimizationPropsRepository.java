package ua.acceptic.optjob.repository;

import ua.acceptic.optjob.domain.OptimizationProps;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the OptimizationProps entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OptimizationPropsRepository extends JpaRepository<OptimizationProps, Long> {

}

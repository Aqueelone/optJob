package ua.acceptic.optjob.service;

import ua.acceptic.optjob.service.dto.BlackListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BlackList.
 */
public interface BlackListService {

    /**
     * Save a blackList.
     *
     * @param blackListDTO the entity to save
     * @return the persisted entity
     */
    BlackListDTO save(BlackListDTO blackListDTO);

    /**
     * Get all the blackLists.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<BlackListDTO> findAll(Pageable pageable);

    /**
     * Get the "id" blackList.
     *
     * @param id the id of the entity
     * @return the entity
     */
    BlackListDTO findOne(Long id);

    /**
     * Delete the "id" blackList.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

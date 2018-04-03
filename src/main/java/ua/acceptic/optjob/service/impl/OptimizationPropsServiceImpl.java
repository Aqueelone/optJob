package ua.acceptic.optjob.service.impl;

import ua.acceptic.optjob.service.OptimizationPropsService;
import ua.acceptic.optjob.domain.OptimizationProps;
import ua.acceptic.optjob.repository.OptimizationPropsRepository;
import ua.acceptic.optjob.service.dto.OptimizationPropsDTO;
import ua.acceptic.optjob.service.mapper.OptimizationPropsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing OptimizationProps.
 */
@Service
@Transactional
public class OptimizationPropsServiceImpl implements OptimizationPropsService {

    private final Logger log = LoggerFactory.getLogger(OptimizationPropsServiceImpl.class);

    private final OptimizationPropsRepository optimizationPropsRepository;

    private final OptimizationPropsMapper optimizationPropsMapper;

    public OptimizationPropsServiceImpl(OptimizationPropsRepository optimizationPropsRepository, OptimizationPropsMapper optimizationPropsMapper) {
        this.optimizationPropsRepository = optimizationPropsRepository;
        this.optimizationPropsMapper = optimizationPropsMapper;
    }

    /**
     * Save a optimizationProps.
     *
     * @param optimizationPropsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public OptimizationPropsDTO save(OptimizationPropsDTO optimizationPropsDTO) {
        log.debug("Request to save OptimizationProps : {}", optimizationPropsDTO);
        OptimizationProps optimizationProps = optimizationPropsMapper.toEntity(optimizationPropsDTO);
        optimizationProps = optimizationPropsRepository.save(optimizationProps);
        return optimizationPropsMapper.toDto(optimizationProps);
    }

    /**
     * Get all the optimizationProps.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OptimizationPropsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OptimizationProps");
        return optimizationPropsRepository.findAll(pageable)
            .map(optimizationPropsMapper::toDto);
    }

    /**
     * Get one optimizationProps by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public OptimizationPropsDTO findOne(Long id) {
        log.debug("Request to get OptimizationProps : {}", id);
        OptimizationProps optimizationProps = optimizationPropsRepository.findOne(id);
        return optimizationPropsMapper.toDto(optimizationProps);
    }

    /**
     * Delete the optimizationProps by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OptimizationProps : {}", id);
        optimizationPropsRepository.delete(id);
    }
}

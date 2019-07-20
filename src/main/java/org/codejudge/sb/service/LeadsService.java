package org.codejudge.sb.service;

import org.codejudge.sb.entity.Leads;
import org.codejudge.sb.error.exception.LeadsException;
import org.codejudge.sb.mapper.LeadsMapper;
import org.codejudge.sb.model.CreateLeadsDto;
import org.codejudge.sb.model.LeadsDto;
import org.codejudge.sb.model.UpdateLeadsDto;
import org.codejudge.sb.repository.LeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LeadsService {

    private LeadsRepository leadsRepository;

    @Autowired
    public LeadsService(LeadsRepository leadsRepository) {
        this.leadsRepository = leadsRepository;
    }

    public LeadsDto getLead(UUID leadsId) throws LeadsException {
        Leads lead = leadsRepository.findById(leadsId);
        if (lead == null) {
            throw new LeadsException("Lead not found!!", HttpStatus.NOT_FOUND, true);
        }
        return LeadsMapper.getLeadsDtoForLead(lead);
    }

    public CreateLeadsDto createLead(LeadsDto leadsDto) throws LeadsException {
        Leads lead = LeadsMapper.createLeadsForLeadsDto(leadsDto);
        try {
            lead = leadsRepository.saveAndFlush(lead);
        }
        catch (Exception e) {
            throw new LeadsException("Error creating lead!!", HttpStatus.BAD_REQUEST);
        }
        return LeadsMapper.getCreateLeadsDtoFromLead(lead);
    }

    public void deleteLead(UUID leadsId) throws LeadsException {
        try {
            leadsRepository.delete(leadsId);
        }
        catch (Exception e) {
            throw new LeadsException(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public void markLead(UUID leadsId, UpdateLeadsDto request) throws LeadsException {
        Leads lead = leadsRepository.findById(leadsId);
        if (lead == null) {
            throw new LeadsException("Lead not found!!", HttpStatus.NOT_FOUND);
        }
        lead.setCommunication(request.getCommunication());
        try {
            leadsRepository.saveAndFlush(lead);
        }
        catch (Exception e) {
            throw new LeadsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public void updateLead(UUID leadsId, LeadsDto leadsDto) throws LeadsException {
        Leads lead = leadsRepository.findById(leadsId);
        if (lead == null) {
            throw new LeadsException("Lead not found!!", HttpStatus.BAD_REQUEST);
        }
        lead = LeadsMapper.updateLeadFromLeadsDto(lead, leadsDto);
        try {
            leadsRepository.saveAndFlush(lead);
        }
        catch (Exception e) {
            throw new LeadsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

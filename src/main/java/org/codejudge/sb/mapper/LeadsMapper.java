package org.codejudge.sb.mapper;

import org.codejudge.sb.entity.Leads;
import org.codejudge.sb.model.CreateLeadsDto;
import org.codejudge.sb.model.LeadsDto;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class LeadsMapper {

    public static LeadsDto getLeadsDtoForLead(Leads lead) {
        LeadsDto leadsDto = new LeadsDto();
        leadsDto.setFirstName(lead.getFirstName());
        leadsDto.setLastName(lead.getLastName());
        leadsDto.setCommunication(lead.getCommunication());
        leadsDto.setMobile(lead.getMobile());
        leadsDto.setLocationString(lead.getLocationString());
        leadsDto.setLocationType(lead.getLocationType());
        leadsDto.setEmail(lead.getEmail());
        return leadsDto;
    }

    public static Leads createLeadsForLeadsDto(LeadsDto leadsDto) {
        Leads lead = new Leads();
        lead.setId(UUID.randomUUID());
        lead.setEmail(leadsDto.getEmail());
        lead.setFirstName(leadsDto.getFirstName());
        lead.setLastName(leadsDto.getLastName());
        lead.setCommunication(leadsDto.getCommunication());
        lead.setMobile(leadsDto.getMobile());
        lead.setLocationString(leadsDto.getLocationString());
        lead.setLocationType(leadsDto.getLocationType());
        return lead;
    }

    public static Leads updateLeadFromLeadsDto(Leads lead, LeadsDto leadsDto) {
        if (!StringUtils.isEmpty(leadsDto.getEmail())){
            lead.setEmail(leadsDto.getEmail());
        }
        if (!StringUtils.isEmpty(leadsDto.getLocationString())){
            lead.setLocationString(leadsDto.getLocationString());
        }
        if (!StringUtils.isEmpty(leadsDto.getLocationType())){
            lead.setLocationType(leadsDto.getLocationType());
        }
        if (!StringUtils.isEmpty(leadsDto.getMobile())){
            lead.setMobile(leadsDto.getMobile());
        }
        if (!StringUtils.isEmpty(leadsDto.getFirstName())){
            lead.setFirstName(leadsDto.getFirstName());
        }
        if (!StringUtils.isEmpty(leadsDto.getLastName())){
            lead.setLastName(leadsDto.getLastName());
        }
        return lead;
    }

    public static CreateLeadsDto getCreateLeadsDtoFromLead(Leads lead) {
        CreateLeadsDto leadsDto = new CreateLeadsDto();
        leadsDto.setId(lead.getId());
        leadsDto.setFirstName(lead.getFirstName());
        leadsDto.setLastName(lead.getLastName());
        leadsDto.setCommunication(lead.getCommunication());
        leadsDto.setMobile(lead.getMobile());
        leadsDto.setLocationString(lead.getLocationString());
        leadsDto.setLocationType(lead.getLocationType());
        leadsDto.setEmail(lead.getEmail());
        return leadsDto;
    }
}

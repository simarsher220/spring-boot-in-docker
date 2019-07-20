package org.codejudge.sb.controller;

import java.util.UUID;

import org.codejudge.sb.error.exception.LeadsException;
import org.codejudge.sb.model.CreateLeadsDto;
import org.codejudge.sb.model.LeadsDto;
import org.codejudge.sb.model.SuccessResponseDto;
import org.codejudge.sb.model.UpdateLeadsDto;
import org.codejudge.sb.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeadsController {

	private LeadsService leadsService;

	@Autowired
	public LeadsController(LeadsService leadsService) {
		this.leadsService = leadsService;
	}

	@RequestMapping(value = "/api/leads/{leadsId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LeadsDto getLeads(@PathVariable("leadsId") UUID leadsId) throws LeadsException {
		return leadsService.getLead(leadsId);
	}

	@RequestMapping(value = "/api/leads/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CreateLeadsDto createLeads(@RequestBody LeadsDto leadsDto) throws LeadsException {
		return leadsService.createLead(leadsDto);
	}

	@RequestMapping(value = "/api/leads/{leadsId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteLeads(@PathVariable("leadsId") UUID leadsId) throws LeadsException {
		leadsService.deleteLead(leadsId);
	}

	@RequestMapping(value = "/api/leads/{leadsId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public SuccessResponseDto updateLeads(@PathVariable("leadsId") UUID leadsId, @RequestBody LeadsDto leadsDto) throws LeadsException {
		leadsService.updateLead(leadsId, leadsDto);
		return new SuccessResponseDto();
	}

	@RequestMapping(value = "/api/mark_lead/{leadsId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SuccessResponseDto markLeads(@PathVariable("leadsId") UUID leadsId, @RequestBody UpdateLeadsDto request) throws LeadsException {
		leadsService.markLead(leadsId, request);
		return new SuccessResponseDto();
	}
}

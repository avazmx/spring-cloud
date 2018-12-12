package com.ups.npt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ups.npt.model.CommunityGovernance;
import com.ups.npt.repository.CommunityGovernanceRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@RestController
@RequestMapping("/community/governance")
public class CommunityGovernanceController {
	
	@Autowired CommunityGovernanceRepository communityGovernanceRepository;
	
	@GetMapping()
	public List<CommunityGovernance> getCommunityGovernance(){
		return communityGovernanceRepository.findAll();
	}
	
	@ResponseBody()
	public ResponseEntity<CommunityGovernance> saveBussinesUnit(@RequestBody CommunityGovernance communityGovernance) {
		try {
			communityGovernance=communityGovernanceRepository.save(communityGovernance);
			log.debug("saved ok");
			return new ResponseEntity<>(communityGovernance,HttpStatus.OK);
		}catch(Exception ex) {
			log.error("Error while serving access level", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
        @GetMapping("/{id}")
        @ResponseBody
	public CommunityGovernance getAccessLevelById(@PathVariable("id") Integer id){
		return communityGovernanceRepository.getcommunityGovernanceRepositoryById(id);
	}
        
        
}

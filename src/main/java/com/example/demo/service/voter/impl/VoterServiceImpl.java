package com.example.demo.service.voter.impl;

import com.example.demo.dto.request.VoterSearchRequest;
import com.example.demo.dto.response.VoterDTO;
import com.example.demo.repository.VoterRepository;
import com.example.demo.service.voter.VoterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {
    private final VoterRepository voterRepository;

    public VoterServiceImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public List<VoterDTO> getVoterByRequest(VoterSearchRequest voterSearchRequest) {
        String firstName = (voterSearchRequest.getFirstName() == null)?"":voterSearchRequest.getFirstName();
        String lastName = (voterSearchRequest.getLastName() == null)?"":voterSearchRequest.getLastName();
        String middleName = ( voterSearchRequest.getMiddleName() == null)?"": voterSearchRequest.getMiddleName();
        List<VoterDTO> result = voterRepository.findAllByRequest(firstName, lastName, middleName);
        return result;
    }
}

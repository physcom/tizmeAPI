package com.example.demo.service.voter.impl;

import com.example.demo.dto.request.VoterSearchRequest;
import com.example.demo.dto.response.VoterDTO;
import com.example.demo.repository.VoterRepository;
import com.example.demo.service.voter.VoterService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {
    private final VoterRepository voterRepository;

    public VoterServiceImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public List<VoterDTO> getVoterByRequest(VoterSearchRequest voterSearchRequest) {
        String firstName = StringUtils.isEmpty(voterSearchRequest.getFirstName())?"+":voterSearchRequest.getFirstName();
        String lastName = StringUtils.isEmpty(voterSearchRequest.getLastName())?"+":voterSearchRequest.getLastName();
        String middleName = StringUtils.isEmpty(voterSearchRequest.getMiddleName())?"+": voterSearchRequest.getMiddleName();
        return voterRepository.findAllByRequest(firstName.toUpperCase(), lastName.toUpperCase(), middleName.toUpperCase());
    }
}

package com.example.demo.service.voter.impl;

import com.example.demo.dto.request.VoterSearchRequest;
import com.example.demo.dto.response.VoterDTO;
import com.example.demo.repository.VoterRepository;
import com.example.demo.service.voter.VoterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VoterServiceImpl implements VoterService {
    private final VoterRepository voterRepository;

    public VoterServiceImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public List<VoterDTO> getVoterByRequest(VoterSearchRequest voterSearchRequest) {
        String firstName = StringUtils.isEmpty(voterSearchRequest.getFirstName())?"-":voterSearchRequest.getFirstName();
        String lastName = StringUtils.isEmpty(voterSearchRequest.getLastName())?"-":voterSearchRequest.getLastName();
        String middleName = StringUtils.isEmpty(voterSearchRequest.getMiddleName())?"-": voterSearchRequest.getMiddleName();
        String tikTitle = StringUtils.isEmpty(voterSearchRequest.getTikTitle())?"-":voterSearchRequest.getTikTitle();
        return voterRepository.findAllByRequest(firstName.toUpperCase(), lastName.toUpperCase(), middleName.toUpperCase(), tikTitle);
    }

    @Override
    public Integer check(VoterSearchRequest voterSearchRequest) {
        String firstName = StringUtils.isEmpty(voterSearchRequest.getFirstName())?"-":voterSearchRequest.getFirstName();
        String lastName = StringUtils.isEmpty(voterSearchRequest.getLastName())?"-":voterSearchRequest.getLastName();
        String middleName = StringUtils.isEmpty(voterSearchRequest.getMiddleName())?"-": voterSearchRequest.getMiddleName();
        String uikTitle = StringUtils.isEmpty(voterSearchRequest.getUikTitle())?"-":voterSearchRequest.getUikTitle();
        return voterRepository.check(firstName.toUpperCase(), lastName.toUpperCase(), middleName.toUpperCase(), uikTitle.toLowerCase()).size();
    }

    @Override
    public List<VoterDTO> listByUikTitle(String uikTitle) {
        return voterRepository.findAllByUik(uikTitle);
    }
}

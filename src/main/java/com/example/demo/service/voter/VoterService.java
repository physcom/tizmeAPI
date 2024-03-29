package com.example.demo.service.voter;

import com.example.demo.dto.request.VoterSearchRequest;
import com.example.demo.dto.response.VoterDTO;

import java.util.List;

public interface VoterService {
    List<VoterDTO> getVoterByRequest(VoterSearchRequest voterSearchRequest);
    List<VoterDTO> listByUikTitle(String uikTitle);
    Integer check(VoterSearchRequest voterSearchRequest);
}

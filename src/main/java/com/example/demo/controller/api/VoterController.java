package com.example.demo.controller.api;

import com.example.demo.dto.request.VoterSearchRequest;
import com.example.demo.dto.response.VoterDTO;
import com.example.demo.service.voter.VoterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/voter/")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @PostMapping("list")
    public List<VoterDTO> list(
            @RequestBody VoterSearchRequest searchRequest
    ) {
        return voterService.getVoterByRequest(searchRequest);
    }
}

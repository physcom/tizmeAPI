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

    @GetMapping("list-uik")
    public List<VoterDTO> listByUik(
            @RequestParam(name = "uikTitle") String uikTitle
    ) {
        return voterService.listByUikTitle(uikTitle);
    }

    @PostMapping("check")
    public ResponseEntity<?> check(
            @RequestBody VoterSearchRequest searchRequest
    ) {
        Integer response = voterService.check(searchRequest);

        return new ResponseEntity<>(new ApiResponse(true, response.toString()), HttpStatus.OK);
    }
}

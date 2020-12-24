package com.example.demo.dto.request;

import lombok.Data;

@Data
public class VoterSearchRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String tikTitle;
}

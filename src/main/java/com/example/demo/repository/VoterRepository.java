package com.example.demo.repository;

import com.example.demo.dto.response.VoterDTO;
import com.example.demo.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface VoterRepository extends JpaRepository<Voter, Long> {

    @Query(value = "select v.first_name as firstName, v.last_name as lastName, v.middle_name as middleName, u.name as uikTitle from voter v left join uik u on u.id = v.uik_id where (?1 = '' or v.first_name LIKE %?1%) and (?2 = '' or v.last_name LIKE %?2%)  and (?3 = '' or v.middle_name LIKE %?3%) limit 5", nativeQuery = true)
    List<VoterDTO> findAllByRequest(String firstName, String lastName, String middleName);
}

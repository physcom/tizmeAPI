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

    @Query(value = "select v.first_name as firstName, v.last_name as lastName, v.middle_name as middleName, u.name as uikTitle, t.name as tikTitle from voter v left join uik u on u.id = v.uik_id left join tik t on u.tik_id = t.id where (?1 = '%-%' or upper(v.first_name) LIKE %?1%) and (?2 = '%-%' or upper(v.last_name) LIKE %?2%)  and (?3 = '%-%' or upper(v.middle_name) LIKE %?3%) and (?4 = '%-%' or t.name like %?4%) limit 100", nativeQuery = true)
    List<VoterDTO> findAllByRequest(String firstName, String lastName, String middleName, String tikTitle);

    @Query(value = "select v.id from voter v left join uik u on u.id = v.uik_id where (?1 = '%-%' or upper(v.first_name) LIKE %?1%) and (?2 = '%-%' or upper(v.last_name) LIKE %?2%)  and (?3 = '%-%' or upper(v.middle_name) LIKE %?3%) and (?4 = '%-%' or lower(u.name) LIKE %?4%)", nativeQuery = true)
    List<VoterDTO> check(String firstName, String lastName, String middleName, String uikTitle);
}

package org.codejudge.sb.repository;

import org.codejudge.sb.entity.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, UUID> {

    @Query(value = "select * from leads where id = :leadsId", nativeQuery = true)
    Leads findById(@Param("leadsId") UUID leadsId);
}

package org.example.repository;


import org.example.entity.Alert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

// Annotation
@Repository

// Class
public interface AlertRepository
        extends CrudRepository<Alert, String> {

    @Query(value = "SELECT * FROM alert_table a WHERE a.alert_ts >= :alert_ts_start and a.alert_ts <= :alert_ts_end" ,  nativeQuery = true)
    public List<Alert> fetchAlertListByTS(@Param("alert_ts_start") Timestamp alert_ts_start, Timestamp alert_ts_end);
}

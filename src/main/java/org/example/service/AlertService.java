package org.example.service;


import org.example.entity.Alert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AlertService {
    // save operation
    Alert saveAlert(Alert alert);

    // read operation
    List<Alert> fetchAlertList();

    // update operation
    Alert updateAlertID(Alert alert, String alert_id);

    // delete operation
    void deleteAlertById(String alert_id);


    List<Alert> fetchAlertListByTS(Timestamp alert_ts_start,Timestamp alert_ts_end );
}

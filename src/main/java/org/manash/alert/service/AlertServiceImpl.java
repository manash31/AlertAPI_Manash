package org.manash.alert.service;

import org.manash.alert.entity.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.manash.alert.repository.AlertRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // save operation
    @Override
    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    // read operation
    @Override
    @Query(value = "SELECT * FROM User Alert_Table")
    public List<Alert> fetchAlertList() {
        return (List<Alert>) alertRepository.findAll();
    }


    // update operation
    @Override
    public Alert updateAlertID(Alert alert, String alert_id) {
        Alert alertDB = alertRepository.findById(alert_id).get();


        if (Objects.nonNull(alert.getService_id()) && !"".equalsIgnoreCase(alert.getService_id())) {
            alertDB.setService_id(alert.getService_id());
        }

        alertDB.setService_id(alert.getService_id());
        alertDB.setService_name(alert.getService_name());
        alertDB.setModel(alert.getModel());
        alertDB.setAlert_type(alert.getAlert_type());
        alertDB.setAlert_ts(alert.getAlert_ts());
        alertDB.setSeverity(alert.getSeverity());
        alertDB.setTeam_slack(alert.getTeam_slack());
        return alertRepository.save(alertDB);
    }

    // delete operation
    @Override
    public void deleteAlertById(String alert_id) {
        alertRepository.deleteById(alert_id);
    }



    @Override
    public List<Alert> fetchAlertListByTS(@Param("alert_ts_start") Timestamp alert_ts_start, @Param("alert_ts_end") Timestamp alert_ts_end) {
        System.out.println("Str 1 "+  alert_ts_start);
        return alertRepository.fetchAlertListByTS( alert_ts_start, alert_ts_end);

    }

}


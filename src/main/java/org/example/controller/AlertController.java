package org.example.controller;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.example.entity.Alert;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.AlertService;

// Annotation
@RestController

// Class
public class AlertController {

    // Annotation
    @Autowired private AlertService alertService;


    // Save operation
    @PostMapping("/createAlert")
    public Alert saveAlert(
            @Valid @RequestBody Alert alert)
    {

        return alertService.saveAlert(alert);
    }

    // Read operation
    @GetMapping("/alerts")
    public List<Alert> fetchAlertList()
    {

        return alertService.fetchAlertList();
    }

    // Update operation
    @PutMapping("/alert/{id}")
    public Alert
    updateAlert(@RequestBody Alert alert,
                     @PathVariable("alert_id") String alert_Id)
    {

        return alertService.updateAlertID(
                alert, alert_Id);
    }

    // Delete operation
    @DeleteMapping("/alert/{id}")
    public String deleteAlertById(@PathVariable("alert_id") String alert_id)
    {
        alertService.deleteAlertById(alert_id);
        return "Deleted Successfully";
    }

    @GetMapping("/api/getAlertBetween")
   // @ResponseBody
    public List<Alert> getAlertByTS(@RequestParam String alert_ts_start, @RequestParam String end_ts) {
       return alertService.fetchAlertListByTS(Timestamp.valueOf(alert_ts_start), Timestamp.valueOf(end_ts));
       // return "start_ts: " + start_ts + " end_ts:" +end_ts;
    }
}


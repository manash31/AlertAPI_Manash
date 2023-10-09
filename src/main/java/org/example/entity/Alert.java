package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Alert_Table")
public class Alert {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String alert_id;
    private String service_id;
    private String service_name;
    private String model;
    private String alert_type;
    private Timestamp alert_ts;
    private String severity;
    private String team_slack;

}

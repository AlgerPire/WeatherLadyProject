package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecifiedInformation {

    private int wind_speed;
    private String wind_dir;
    private int temperature;
    private String observation_time;
}

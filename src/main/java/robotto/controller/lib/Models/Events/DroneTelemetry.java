package robotto.controller.lib.Models.Events;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneTelemetry implements Serializable {
    
    @JsonProperty
    private final String ID = "qeqweqweqwe12";//utils.generateId(); // static service
    @JsonProperty
    private String missionId;
    @JsonProperty
    private String droneId;
    @JsonProperty
    private float homePointAltitude;
    @JsonProperty
    private Gimbal gimbal;
    @JsonProperty
    private GpsFused gpsFused;
    @JsonProperty
    private Quaternion quaternion;


    @Override
    public String toString() {
        return "DroneTelemetry{" +
                "ID='" + ID + '\'' +
                ", missionId=" + missionId +
                ", droneId=" + droneId +
                ", homePointAltitude='" + homePointAltitude + 
                ", gimbal=" + gimbal.toString() +
                ", gpsFused=" + gpsFused.toString() +
                ", quaternion=" + quaternion.toString() + '\'' +
                '}';
    }
}
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
public class GpsFused implements Serializable {
    
    @JsonProperty
    private float altitude;
    @JsonProperty
    private float latitude;
    @JsonProperty
    private float longitude;
    @JsonProperty
    private int visibleSatelliteNumber;

    @Override
    public String toString() {
        return "GpsFused{" +
                "altitude='" + altitude + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude + 
                ", visibleSatelliteNumber=" + visibleSatelliteNumber + '\'' +
                '}';
    }
}

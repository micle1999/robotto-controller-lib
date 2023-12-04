package robotto.controller.lib.Models.CosmosDb;

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
public class Location implements Serializable {
    
    @JsonProperty
    private float latitude;
    
    @JsonProperty
    private float longitude;
    

    @Override
    public String toString() {
        return "Location{" +
                "Latitude='" + latitude + '\'' +
                ", Longitude=" + longitude + '\'' +
                '}';
    }
}

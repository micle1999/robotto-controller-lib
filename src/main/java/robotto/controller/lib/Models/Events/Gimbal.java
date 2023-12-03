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
public class Gimbal implements Serializable {
    
    @JsonProperty
    private int mode;
    @JsonProperty
    private float pitch;
    @JsonProperty
    private float roll;
    @JsonProperty
    private int status;    
    @JsonProperty
    private float yaw;

    @Override
    public String toString() {
        return "Gimbal{" +
                "mode='" + mode + '\'' +
                ", pitch=" + pitch +
                ", roll=" + roll +
                ", status='" + status + 
                ", yaw=" + yaw + '\'' +
                '}';
    }
}

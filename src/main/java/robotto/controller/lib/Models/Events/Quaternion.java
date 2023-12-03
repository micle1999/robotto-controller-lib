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
public class Quaternion implements Serializable {
    
    @JsonProperty
    private float q0;
    @JsonProperty
    private float q1;
    @JsonProperty
    private float q2;
    @JsonProperty
    private float q3;

    @Override
    public String toString() {
        return "Quaternion{" +
                "q0='" + q0 + '\'' +
                ", q1=" + q1 +
                ", q2=" + q2 + 
                ", q3=" + q3 + '\'' +
                '}';
    }
}

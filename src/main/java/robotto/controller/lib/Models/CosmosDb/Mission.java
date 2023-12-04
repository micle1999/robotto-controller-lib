package robotto.controller.lib.Models.CosmosDb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.rmi.server.UID;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mission implements Serializable {
    
    @JsonProperty
    private String ID = new UID().toString();
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private String type;

    @JsonProperty
    private LocalDateTime created = LocalDateTime.now();

    @JsonProperty
    private boolean active;

    @JsonProperty
    private Location location;

    @Override
    public String toString() {
        return "Mission{" +
                "ID='" + ID + '\'' +
                ", name=" + name +
                ", type=" + type +
                ", created=" + created.toString() +
                ", active=" + active +
                ", location=" + location.toString() + '\'' +
                '}';
    }
}


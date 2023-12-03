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
public class ResourceMetadata implements Serializable {
    
    @JsonProperty
    private String ID = new UID().toString();
    
    @JsonProperty
    private String missionId;
    
    @JsonProperty
    private String blobStorageUri;

    @JsonProperty
    private String type;

    @JsonProperty
    private LocalDateTime created = LocalDateTime.now();

    @JsonProperty
    private boolean raw;

    @Override
    public String toString() {
        return "ResourceMetadata{" +
                "ID='" + ID + '\'' +
                ", missionId=" + missionId +
                ", blobStorageUri=" + blobStorageUri +
                ", type=" + type +
                ", created=" + created.toString() +
                ", raw=" + raw + '\'' +
                '}';
    }
}

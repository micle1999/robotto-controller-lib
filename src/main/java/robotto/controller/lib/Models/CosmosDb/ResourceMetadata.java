package robotto.controller.lib.Models.CosmosDb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import robotto.controller.lib.Models.BlobStorage.Resource;

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

    public ResourceMetadata(Resource resource, String uri) {
        super();
        missionId = resource.getMissionId();
        blobStorageUri = uri;
        type = resource.getType();
        raw = resource.isRaw();
    }

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

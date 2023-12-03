package robotto.controller.lib.Models.BlobStorage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resource implements Serializable {
    
    private String missionId;
    
    private String type;
    
    private boolean raw;

    private MultipartFile data;

    @Override
    public String toString() {
        return "Resource{" +
                "missionId='" + missionId + '\'' +
                ", type=" + type +
                ", data=" + data.getOriginalFilename() + '\'' +
                '}';
    }
}
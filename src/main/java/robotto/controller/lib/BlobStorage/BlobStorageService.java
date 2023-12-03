package robotto.controller.lib.BlobStorage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import robotto.controller.lib.Utils;
import robotto.controller.lib.Models.BlobStorage.Resource;

@Service
public class BlobStorageService {
    

    @Value("${azure.storage.blob.account-name}")
    private String accountName;

    @Value("${azure.storage.blob.account-key}")
    private String accountKey;

    @Value("${azure.storage.blob-endpoint}")
    private String blobEndpoint;

    private static Logger logger = LogManager.getLogger(BlobStorageService.class.toString());


    public String uploadBlob(Resource resource) throws IOException{
        String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net", accountName, accountKey);

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        
        //log
        
        String container = Utils.getContainerName(resource.getType(), resource.getMissionId());
        String resourceId = Utils.generateID(resource.getMissionId(), resource.getData().getOriginalFilename());
        blobServiceClient.getBlobContainerClient(container).getBlobClient(resourceId).upload(resource.getData().getInputStream());
        return String.format("%s/%s/%s", blobEndpoint, container, resourceId);
    }

}
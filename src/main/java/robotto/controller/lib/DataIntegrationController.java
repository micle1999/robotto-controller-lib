package robotto.controller.lib;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import robotto.controller.lib.BlobStorage.BlobStorageService;
import robotto.controller.lib.CosmosDb.CosmosDbService;
import robotto.controller.lib.EventStream.EventPublisher;
import robotto.controller.lib.Models.BlobStorage.Resource;
import robotto.controller.lib.Models.CosmosDb.ResourceMetadata;
import robotto.controller.lib.Models.CosmosDb.Mission;
import robotto.controller.lib.Models.Events.DroneTelemetry;

@Service
public class DataIntegrationController {

   @Autowired
   EventPublisher eventPublisher;

   @Autowired
   BlobStorageService blobService;

   @Autowired
   CosmosDbService cosmosService;

   void uploadResource(Resource resource){
        try {
          String resourceUri = blobService.uploadBlob(resource); 
          ResourceMetadata metadata = new ResourceMetadata();
          metadata.setMissionId(resource.getMissionId());
          metadata.setBlobStorageUri(resourceUri);
          metadata.setType(resource.getType());
          metadata.setRaw(resource.isRaw());
          cosmosService.uploadMetadata(metadata);
        } catch (IOException e) {
          
        }
   }

   void publishTelemetryEvent(DroneTelemetry telemetry){
        eventPublisher.publishTelemetry(telemetry);
   }

   void createMission(Mission mission){
        cosmosService.createMission(mission);
   }

}
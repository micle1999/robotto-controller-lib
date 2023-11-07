package robotto.controller.lib;

public interface BlobStorageService {

    //mission Id will represent container in blob storage
    int uploadResource(String missionId, Resource resource); //returns resource id for metadata storage


}
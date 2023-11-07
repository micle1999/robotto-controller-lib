package robotto.controller.lib;

public interface CosmosDbService {

    //Create class for input parameters
    boolean storeResourceMetadata(String missionId, String resourceId, String resourceType);

    boolean createMission(MissionData data);

    //find out what other data we store in the db
}
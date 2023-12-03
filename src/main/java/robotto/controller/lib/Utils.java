package robotto.controller.lib;

public class Utils {
    
    public static String generateID(String missionId, String filename){
        return missionId + "-" + filename;
    }

    public static String getContainerName(String resourceType, String missionId){
        return resourceType + "-" + missionId;
    }
}

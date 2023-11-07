package robotto.controller.lib.Controller;

public interface Controller {

    boolean uploadResource(String missionId, Resource resource);

    boolean publishEvent(String missionId, String eventType, String payload);

    boolean createMission(MissionData data);

}
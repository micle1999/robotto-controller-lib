package robotto.controller.lib;

public interface EventStreamService {

    boolan publishEvent(String missionId, String eventType, String payload);

    //what other methods do we need
}
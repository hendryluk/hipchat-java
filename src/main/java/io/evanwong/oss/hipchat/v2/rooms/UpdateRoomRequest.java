package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.NoContent;
import io.evanwong.oss.hipchat.v2.commons.PutRequest;
import org.apache.http.client.HttpClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class UpdateRoomRequest extends PutRequest<NoContent> {
    private String roomIdOrName;
    private String name;
    private Privacy	privacy;
    private Boolean	archived;
    private Boolean	guestAccessible;
    private String topic;
    private String ownerIdOrEmail;

    public UpdateRoomRequest(String roomIdOrName, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
    }

    public String getRoomIdOrName() {
        return roomIdOrName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getGuestAccessible() {
        return guestAccessible;
    }

    public void setGuestAccessible(Boolean guestAccessible) {
        this.guestAccessible = guestAccessible;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOwnerIdOrEmail() {
        return ownerIdOrEmail;
    }

    public void setOwnerIdOrEmail(String ownerIdOrEmail) {
        this.ownerIdOrEmail = ownerIdOrEmail;
    }

    @Override
    protected String getPath() {
        return "/room/" + roomIdOrName;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        if (topic != null) {
            params.put("topic", topic);
        }
        if (guestAccessible != null) {
            params.put("is_guest_accessible", guestAccessible);
        }
        if (name != null) {
            params.put("name", name);
        }
        if (archived != null) {
            params.put("is_archived", archived);
        }
        if (privacy != null) {
            params.put("privacy", privacy.getValue());
        }
        if (ownerIdOrEmail != null) {
            params.put("owner", Collections.singletonMap("id", ownerIdOrEmail));
        }
        return params;
    }
}

package api.steps;

import api.model.UserData;
import org.junit.Assert;
import java.util.List;

public class AvatarAndId {
    public void checkAvatarsContainIds(List<UserData> users) {
        for (UserData user : users) {
            Assert.assertTrue(
                    "Avatar does not contain user ID: " + user.getId(),
                    user.getAvatar().contains(user.getId().toString())
            );
        }
    }
}

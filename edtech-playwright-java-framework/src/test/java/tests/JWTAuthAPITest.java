
package tests;

import api.AuthAPI;
import api.CourseAPI;
import com.microsoft.playwright.APIResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JWTAuthAPITest {

    @Test
    public void verifyJWTFlow() {

        AuthAPI auth = new AuthAPI();
        String token = auth.getJWTToken("admin@edtech.com", "admin123");

        Assert.assertNotNull(token);

        CourseAPI api = new CourseAPI(token);
        APIResponse response = api.getCourses();

        Assert.assertEquals(response.status(), 200);
    }
}

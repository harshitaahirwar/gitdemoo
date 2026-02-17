
package api;

import com.microsoft.playwright.*;
import java.util.Map;

public class CourseAPI {

    private APIRequestContext request;

    public CourseAPI(String token) {

        Playwright playwright = Playwright.create();

        request = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setExtraHTTPHeaders(
                                Map.of("Authorization", "Bearer " + token)
                        )
        );
    }

    public APIResponse getCourses() {
        return request.get("https://edtech-app/api/courses");
    }
}

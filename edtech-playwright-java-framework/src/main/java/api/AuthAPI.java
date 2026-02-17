
package api;

import com.microsoft.playwright.*;
import org.json.JSONObject;

public class AuthAPI {

    public String getJWTToken(String email, String password) {

        Playwright playwright = Playwright.create();
        APIRequestContext request = playwright.request().newContext();

        String body = "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";

        APIResponse response = request.post(
                "https://edtech-app/api/auth/login",
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setData(body)
        );

        JSONObject json = new JSONObject(response.text());
        return json.getString("token");
    }
}

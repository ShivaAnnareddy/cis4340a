import java.util.logging.Logger;

public class LoginHandler {
    private static final Logger logger = Logger.getLogger(LoginHandler.class.getName());

    public static void main(String[] args) {
        String username = "exampleUser@2024";
        boolean loginSuccessful = true;  // This should be set based on your actual login logic

        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + sanitizeUser(username));
        } else {
            logger.severe("User login failed for: " + sanitizeUser(username));
        }
    }

    public static String sanitizeUser(String username) {
        // Remove non-alphanumeric characters and trim extra spaces.
        return username.replaceAll("[^A-Za-z0-9]", "").trim();
    }
}

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static void main(String[] args) throws Exception {
        // Read port from environment variable, default to 8080 if not set
        String portEnv = System.getenv("PORT");
        int port = (portEnv != null && !portEnv.isEmpty()) ? Integer.parseInt(portEnv) : 8080;
        
        System.out.println("Starting server on port: " + port);
        Server server = new Server(port);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        
        // Point to the built WAR file
        // Make sure you run `mvn clean package` before running this
        context.setWar("target/backend.war");

        server.setHandler(context);
        server.start();
        server.join();
    }
}

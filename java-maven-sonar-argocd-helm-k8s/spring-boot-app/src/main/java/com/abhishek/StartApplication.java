import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String getPodDetails() {
        String podIp = "";
        String nodeIp = System.getenv("KUBERNETES_NODE_IP"); // Get Node IP from environment

        try {
            podIp = InetAddress.getLocalHost().getHostAddress(); // Get Pod IP
        } catch (UnknownHostException e) {
            podIp = "Unknown";
        }

        return "<h1>Pod IP: " + podIp + "</h1>\n" +
               "<h1>Node IP: " + (nodeIp != null ? nodeIp : "Unknown") + "</h1>";
    }
}

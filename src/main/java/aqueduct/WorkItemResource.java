package aqueduct;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class WorkItemResource extends ServerResource {
    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8182, WorkItemResource.class).start();
    }
 
    @Get
    public String toString() {
        // TODO first cut:
        //  - save current blinky bill json in a file.
        //  - reading and return the json string from that file.
        return "TODO: deliver work item structure in json";
    }
}

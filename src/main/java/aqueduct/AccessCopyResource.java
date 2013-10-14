package aqueduct;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class AccessCopyResource extends ServerResource {
    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8183, AccessCopyResource.class).start();
    }
 
    @Get
    public String toString() {
        // TODO first cut:
        //  - return a hard coded image url from blinky bill.
        return "TODO: return iip url for requested jp2 of the work item";
    }
}

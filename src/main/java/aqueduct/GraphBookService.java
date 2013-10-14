package aqueduct;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class GraphBookService extends ServerResource {
    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8185, GraphBookService.class).start();
    }
 
    /**
     * Graphs a book with all of its pages.  
     * This graph can be used as import into amberdb.  
     */
    @Get
    public String toString() {
        // TODO 
        //  @Bind IngestParams
        //
        // This service functions similarily to the GraphPageService,
        // except instead of graph a book with a single page, this
        // graphs a book with multiple pages.
        //
        // Note: for testing, the output of this service can be loaded into
        //       amberdb via cmdLoad.
        return "TODO: return graphson of a book's structmap.";
    }
}

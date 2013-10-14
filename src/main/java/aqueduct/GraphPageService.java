package aqueduct;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.restlet.Server;
import org.restlet.data.Form;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import amberdb.AmberDb;
import amberdb.AmberSession;
import amberdb.enums.CopyRole;
import amberdb.model.Page;
import amberdb.model.Work;

public class GraphPageService extends ServerResource {
    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8184, GraphPageService.class).start();
    }
 
    /**
     * Graphs a book with a single page for checking all available copies
     * ie imaging and/or ocr masters and derivatives are located, attached
     * and indexed correctly.
     * 
     * This graph can be used as import into amberdb.  
     */
    @Get
    public String toString() {        
        // TODO
        // @Bind IngestParams
        try {
            Form form = this.getRequest().getResourceRef().getQueryAsForm();
            
            Map<String, String> parentMD = extractParentMD(form);
            Map<CopyRole, Path> copyPaths = extractCopyPaths(form);

            return graph(parentMD, copyPaths).toString();
        } catch (IOException e) {
            // TODO: log exception
            return null;
        }
    }
    
    
    private Map<CopyRole, Path> extractCopyPaths(Form form) {
        // TODO Auto-generated method stub
        return null;
    }

    private Map<String, String> extractParentMD(Form form) {
        
        return null;
    }

    /**
     * Given metadata for the parent work, find or create the parent work item,
     * then create the page, make and attach copies to the page
     * from the copyPaths specified, and finally link the page to the
     * parent work item.
     *
     * This allow us to do the following:
     *  - fast track checking of an ingest by just ingest e.g. one page for a book
     *    to verify the store of master, generation of derivative and solr text indexing.
     *    
     *  - also allow current ingest of e.g. subsequent pages for a book after the ingest
     *    of the first page.     
     * @param parentMD
     * @param copyPaths
     * @return
     * @throws IOException 
     */
    private JsonNode graph(Map<String, String> parentMD,
            Map<CopyRole, Path> copyPaths) throws IOException {
        try (AmberSession db = new AmberDb(null, Paths.get(".")).begin()) {
            if (parentMD == null)
                throw new IllegalArgumentException(
                        "Can not create the work item for ingest as the input metadata is null.");

            Work work = findOrCreateWork(db, parentMD);
            Page page = work.addPage();
            map(page, copyPaths);
            return db.serializeToJson();
        }
    }

    private void map(Page page, Map<CopyRole, Path> copyPaths) {
        // TODO Auto-generated method stub
        
    }

    private Work findOrCreateWork(AmberSession db, Map<String, String> parentMD) {
        // TODO Auto-generated method stub
        return null;
    }
}

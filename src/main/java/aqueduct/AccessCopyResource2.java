package aqueduct;

import java.io.IOException;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import amberdb.AmberDb;
import amberdb.AmberSession;
import amberdb.enums.CopyRole;
import amberdb.model.File;
import amberdb.model.Work;

public class AccessCopyResource2 extends ServerResource {
    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8183, AccessCopyResource.class).start();
    }
 
    @Get
    public String toString() {
        // TODO first cut:
        //  - return a hard coded image url from blinky bill.
        
        // TODO: find how to bind request parameter(s)
        long objId = 2L;
        try {
            long jp2ImgDossId = getAccessFile(objId).getBlobId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "TODO: return iip url for requested jp2 of the work item";
    }
    
    private File getAccessFile(long objId) throws IOException {
        // TODO: define DataSource for amberdb
        DataSource ds = null;
        try (AmberSession db = new AmberDb(ds, Paths.get("/doss-devel/dlir/doss")).begin()) {
            return db.findWork(objId).getCopy(CopyRole.ACCESS_COPY).getFile();
        } 
    }
}

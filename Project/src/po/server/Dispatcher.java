package po.server;

/**
 * Generates the answer by request
 */
public class Dispatcher {

    private static final String DUMMY_FIELD
            = "0120120120"
            + "1201201201"
            + "2012012012"
            + "0120120120"
            + "1201201201"
            + "2012012012"
            + "0000000000"
            + "0120120120"
            + "1201201201"
            + "2012012012";
    
    public boolean isExit(String request) {
        if( request==null ) {
            return true;
        }
        return request.startsWith("E");
    }

    public String makeResponse(String request) {
        if( request==null ) {
            return null;
        }
        if (request.startsWith("M")) {
            // TODO generate new field
            return DUMMY_FIELD;
        } else {
            return null;
        }
    }

}

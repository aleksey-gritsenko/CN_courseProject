package po.server;

import java.util.logging.Logger;

/**
 * Generates the answer by request
 */
public class Dispatcher {

    private Integer[][] map;
    private Integer currentPlayer;
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
    public Dispatcher(){
        currentPlayer = 0;
        map = new Integer[10][10];
        for (int i = 0; i<10 ; i++){
            if((i == 0) || (i == 9)){
                for (int j =0; j<10; j++){
                    map[i][j] = 1;
                }
            }
            else {
                map[i][0] = 1;
                map[i][9] = 1;
                for (int j =1; j<9; j++){
                    map[i][j] = 0;
                }
            }

        }
        map[1][1] = 2;
        map[8][8] = 2;

    }

    private String mapToString(){
        String mapString = "";
        for (int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                mapString += map[i][j].toString();
            }
        }
        return mapString;
    }

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
            System.out.println("Stage 1");
            StringBuilder name = new StringBuilder(request);
            String separator = ".";
            int index1 = name.indexOf(separator);
            int index2 = name.indexOf(separator,index1 + 1);
            int index3 = name.indexOf(separator, index2 + 1);
            System.out.println("Stage 2");
            Integer x = Integer.parseInt(name.substring(index1+1,index2));
            Integer y = Integer.parseInt(name.substring(index2+1,index3));
            Integer requestPlayer = Integer.parseInt(name.substring(index3+1));
            // generate new field
            System.out.println("Stage 3");
            if( currentPlayer.compareTo(requestPlayer) == 0){
                map[y.intValue()][x.intValue()] = 2;
                currentPlayer = (currentPlayer.intValue() + 1)%2;
            }
            System.out.println("Stage 4");
            return mapToString();
        } else {
            return null;
        }
    }

}

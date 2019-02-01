package org.qgeff;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Database db = new Database("C:\\Users\\QG3D4DBN\\db");
        
        if(args.length<2  || args.length>3){
            System.out.println( "get ou set + key + val si get" );
            System.exit(1);
        }
        
        if(args[0].equals("set"))
            db.set(args[1],args[2]);
        
        if(args[0].equals("get"))
            System.out.println(db.get(args[1]));
    }
}

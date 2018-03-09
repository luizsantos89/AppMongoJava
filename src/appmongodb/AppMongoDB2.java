/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appmongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Oneide
 */
public class AppMongoDB2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("local");

        DBCollection table = db.getCollection("aluno");

        BasicDBObject document = new BasicDBObject();
        document.put("nome", "Pedro dos Santos");
        document.put("_id", 5);
        table.insert(document);

        Set<String> colls = db.getCollectionNames();
        for (String s : colls) {
            System.out.println(s);
        }
        
        DBObject pessoa = table.findOne();
        System.out.println(pessoa);
        
        DBCursor cursor = table.find();        
        while(cursor.hasNext()){
            BasicDBObject aluno = (BasicDBObject) cursor.next();
            
            System.out.println("ID: "+aluno.getString("_id"));
            System.out.println("Nome: " + aluno.getString("nome"));
            
            System.out.println("==========================");
        }
    }
}

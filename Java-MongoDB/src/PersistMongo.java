
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Allef
 */
public class PersistMongo {
    public static void main(String[] args) {
        // conectando ao mongo, como esta sem parametros
        //se conecta ao mongo local por default 
        MongoClient mongoClient = new MongoClient("localhost",27017);
        
        // Base de dados
        DB db = (DB) mongoClient.getDB("JavaDB");
        // Tabela 
        DBCollection collection = db.getCollection("colJava");
        // objeto para ser persistido
        BasicDBObject document1 = new BasicDBObject();
        document1.put("id",1001);
        document1.put("msg","Persistencia com mongoDB");
        
        // salvando o documento na base nosql
        collection.insert(document1);
        BasicDBObject document = new BasicDBObject();
        document = new BasicDBObject();
        document.put("id",1002);
        document.put("msg","Java + Mongo");
        
         // salvando o documento na base nosql
         collection.insert(document);
         // objeto que recebe os dados do banco
        DBCursor cursor = collection.find();
        // percorrendo o objeto e mostrando os dados
        while  (cursor.hasNext()){
            System.out.println("Document: "+cursor.next());
            
        }
        // Passando o documento que sera removido
        collection.remove(document);
        // Passando o documentoque sera atualizado e o documento que entrara em seu lugar 
        collection.update(document, document1);
        
    }
}

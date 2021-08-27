package db.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;

/**
 * Run as Java application to create MongoDB collections with index and remove
 * all old collections
 * @author morgan
 *
 */
public class MongoDBTableCreation {
	public static void main(String[] args) {
		//Connect to Mongo DB
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase db = mongoClient.getDatabase(MongoDBUtil.DB_NAME);
		
		//Remove old collections
		db.getCollection("users").drop();
		db.getCollection("items").drop();
		
		//Create new collections
		IndexOptions indexOptions = new IndexOptions().unique(true);
		db.getCollection("users").createIndex(new Document("user_id", 1), indexOptions);
		db.getCollection("items").createIndex(new Document("item_id", 1), indexOptions);
		
		//Insert fake user for testing
		db.getCollection("users").insertOne(
				new Document().append("user_id", "1111").append("password", "ec7d088499fd980d6f628dcf8a96694d")
				.append("first_name", "John").append("last_name", "Doe"));
		mongoClient.close();
		System.out.println("Import is done successfully");
	}
}

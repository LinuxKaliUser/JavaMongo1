package server;

import com.mongodb.client.FindIterable;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoServer implements MongoInterface {
    private static final String ZUERICH2 = "zuerich";
	private static final String BASELLAND2 = "baselland";
	private static final String BASEL2 = "basel";
	private static final String BEZEICHNUNGEN_FUER_ZUERICH = "Bezeichnung_Fuer_Zuerich";
	private static final String BEZEICHNUNGEN_FUER_BASEL = "Bezeichnung_Fuer_Basel";
	private static final String BEZEICHNUNGEN_FUER_BASELLAND = "Bezeichnung_Fuer_Baselland";
	private MongoDatabase database;

    public MongoServer() {
        // Connect to the MongoDB instance running in the Docker container
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Get a handle to the "myapp" database
        database = mongoClient.getDatabase("myapp");
        MongoCollection<Document> collection = database.getCollection(BASEL2);
        FindIterable<Document> find = collection.find(new Document(BEZEICHNUNGEN_FUER_BASEL, BASEL2));
        boolean existBasel= false;
        for (Document d:find) {
        	existBasel=d.containsValue(BASEL2);
        }
        if(!existBasel){

        //Create Collection

			database.createCollection(BASEL2);
			database.createCollection(BASELLAND2);
			database.createCollection(ZUERICH2);
	
			
			// Create collection documents
			MongoCollection<Document> collectionBasel = database.getCollection(BASEL2);
			List<String> basel = new ArrayList<String>();
			basel.add("Basel");
			basel.add(BASEL2);
			basel.add("basel+");
			basel.add("Basel-Stadt");
			basel.add("basel-stadt");
			manyDocument(getDocs(basel, BEZEICHNUNGEN_FUER_BASEL),collectionBasel);
			
			MongoCollection<Document> collectionBaselland = database.getCollection(BASELLAND2);
			List<String> baselland = new ArrayList<String>();
			baselland.add("Basel-Landschaft");
			baselland.add("basel-landschaft");
			baselland.add("Baselland");
			baselland.add(BASELLAND2);
			baselland.add("baselland+");
			baselland.add("Baselbiet");
			baselland.add("baselbiet");
			manyDocument(getDocs(baselland, BEZEICHNUNGEN_FUER_BASELLAND),collectionBaselland);	
			
			MongoCollection<Document> collectionZuerich = database.getCollection(ZUERICH2);
			List<String> zuerich = new ArrayList<String>();
			zuerich.add("Zürich");
			zuerich.add("zürich");
			zuerich.add("zuerich+");
			zuerich.add("Zuerich");
			zuerich.add(ZUERICH2);		
			manyDocument(getDocs(zuerich, BEZEICHNUNGEN_FUER_ZUERICH),collectionZuerich);
		}
    }

	private List<Document> getDocs(List<String> basel, String bezeichnungenFuerKantone) {
		List<Document> docs = new ArrayList<Document>();
		for (String name:basel) {
			docs.add(new Document(bezeichnungenFuerKantone,name ));
		}
		return docs;
	}

    private void manyDocument(List<Document> docs, MongoCollection<Document> c) {
        // Insert a document into the collection
        c.insertMany(docs);
    }

	
	public List<String> findDocuments(String collectionName) {
		List<String> result = new ArrayList<String>();
		 MongoCollection<Document> collection = database.getCollection(collectionName);
		 FindIterable<Document> find = collection.find();
		 for (Document document : find) {
			 getResult(collectionName, result, document);
			
		}
		return result;
	}

	private void getResult(String collectionName, List<String> result, Document doc) {
		if (collectionName.equals(BASEL2)) {
			 result.add(doc.get(BEZEICHNUNGEN_FUER_BASEL).toString());
		 }else if (collectionName.equals(BASELLAND2)) {
			 result.add(doc.get(BEZEICHNUNGEN_FUER_BASELLAND).toString());
		 }else if (collectionName.equals(ZUERICH2)) {
			 result.add( doc.get(BEZEICHNUNGEN_FUER_ZUERICH).toString());
		 }
	}

	private String getStringAttribute(Document doc, String objectName) {
//		String object = doc.getString(objectName);
		return (doc.getString(objectName).isBlank())?doc.getString(objectName):null;
	}

  
}

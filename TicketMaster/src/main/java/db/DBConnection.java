package db;

import java.util.List;
import java.util.Set;

import entity.Item;

/**
 * Interface for database connections
 * @author morgan
 *
 */
public interface DBConnection {
	
	
	/**
	 * Register a user
	 * 
	 * @return true one success, false otherwise
	 */
	public boolean registerUser(String userId, String password, String firstname, String lastname);
	
	/**
	 * Close the connection
	 */
	public void close();
	
	/**
	 * Insert favorite items for a user
	 * @param userId The user id
	 * @param itemIds List of item ids that should be added
	 */
	public void setFavoriteItems(String userId, List<String> itemIds);
	
	/**
	 * Delete favorite items for a user
	 * @param userId The user id
	 * @param itemIds List of item ids that should be removed
	 */
	public void unsetFavoriteItems(String userId, List<String> itemIds);
	
	/**
	 * Get the favorite item ids for a user
	 * @param userId The id of the user
	 * @return A set of favorite item ids
	 */
	public Set<String> getFavoriteItemIds(String userId);
	
	/**
	 * Gets favorite item for a user
	 * @param userId The id of the user
	 * @return A set of favorite item
	 */
	public Set<Item> getFavoriteItems(String userId);
	
	/**
	 * Gets a set of categories of an event
	 * @param itemId the id of the event
	 * @return The set of categories
	 */
	public Set<String> getCategories(String itemId);
	
	/**
	 * Search items near a geo-location with an optional keyword
	 * @param lat latitude of the search circle
	 * @param lon longitude of the search circle
	 * @param term keyword for search (Nullable)
	 * @return list of items(events)
	 */
	public List<Item> searchItems(double lat, double lon, String term);
	
	/**
	 * Save item into data base
	 * @param item item to save
	 */
	public void saveItem(Item item);
	
	/**
	 * Get the full name of a user from their id
	 * @param userId the user id
	 * @return full name of the user
	 */
	public String getFullname(String userId);
	
	/**
	 * Return whether the credential is correct
	 * @param userId id of the user to verify
	 * @param password password of the user
	 * @return true if credential is correct, else false
	 */
	public boolean verifyLogin(String userId, String password);
}

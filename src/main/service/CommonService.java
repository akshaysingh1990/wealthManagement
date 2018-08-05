package main.service;

import main.utils.WealthUtils;

public interface CommonService {
	WealthUtils wealthUtils = new WealthUtils();

	void create();
	
	// delete
	
	void viewAll();
	
	
	void delete();
	
	void edit();
	// only editing of name is provided
	
	void getAll();
	
	
	
}

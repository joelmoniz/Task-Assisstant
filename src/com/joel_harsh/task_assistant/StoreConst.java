package com.joel_harsh.task_assistant;

public class StoreConst {

	public static final int DATABASE_VERSION = 1;
	public static final String TABLENAME = "Tasklist";
	final static public String DBNAME = "Userdata.db";
	final static public String NAME = "Task_Name";
	final static public String DATE = "Task_Deadline";
	final static public String PR = "Task_Priority";
	final static public String STATUS = "Task_Status";   // 0 = To Do ; 1 = Done
	public static final String CREATE_TABLE = "CREATE TABLE " + TABLENAME
			+ " (" + StoreConst.NAME + " TEXT PRIMARY KEY," + StoreConst.DATE
			+ " TEXT," + StoreConst.PR + " TEXT," + StoreConst.STATUS + " INTEGER"
			+ " );";
	public static final String SortBy = "DataBaseSortingOrder";
	public static final String DoStatus = "Do_Status";
	public static final String Store = "stored_String";
}

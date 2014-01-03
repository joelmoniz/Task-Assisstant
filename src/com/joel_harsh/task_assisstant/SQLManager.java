package com.joel_harsh.task_assisstant;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLManager extends SQLiteOpenHelper {

	private static SQLManager sqlObj = null;
	String currUser = null;

	private SQLManager(Context context) {
		super(context, StoreConst.DBNAME, null, StoreConst.DATABASE_VERSION);

		// TODO Auto-generated constructor stub

	}

	public static SQLManager createObject(Context context) // Singleton pattern
	{

		if (sqlObj == null)
			sqlObj = new SQLManager(context);

		return sqlObj;

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(StoreConst.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Lite- no upgradation of Tables needed in this project
	}

	public static void newTask(String tName, String tDate, String tPr) {
		
		SQLiteDatabase db = sqlObj.getWritableDatabase();//this.getWritableDatabase();
		// Inserting Row
		db.execSQL("INSERT INTO " + StoreConst.TABLENAME + "('"
				+ StoreConst.NAME + "', '" + StoreConst.DATE + "', '"
				+ StoreConst.PR + "', '" + StoreConst.STATUS + "')  VALUES ('"
				+ tName + "', '" + tDate + "', '" + tPr + "', 0);");
		db.close();

	}

	public Cursor getTaskByName(int status) {

		SQLiteDatabase db = this.getReadableDatabase();
		/*
		 * Cursor cursor = db.query(StoreConst.TABLENAME, null,
		 * StoreConst.STATUS + "= " + status, null, StoreConst.NAME, null,
		 * " "+StoreConst.NAME+" ASC");
		 */
		Cursor cursor = db.rawQuery("SELECT * FROM " + StoreConst.TABLENAME,
				null);
		// + " WHERE " + StoreConst.STATUS + "= " + status
		// + " ORDER BY "
		// + StoreConst.NAME + " ASC", null);
		return cursor;
	}

	public Cursor getTaskByDate(int status) {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(StoreConst.TABLENAME, null, StoreConst.STATUS
				+ "= " + status, null, StoreConst.DATE, null, "'"
				+ StoreConst.DATE + "' DESC");
		return cursor;
	}

	public Cursor getTaskByPr(int status) {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(StoreConst.TABLENAME, null, StoreConst.STATUS
				+ "= " + status, null, StoreConst.PR, null, "'" + StoreConst.PR
				+ "' DESC");

		return cursor;
	}

	public void clearDataBase() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DELETE FROM " + StoreConst.TABLENAME);
	}
	/*
	 * public void clearData() { SQLiteDatabase db = this.getWritableDatabase();
	 * db.execSQL("UPDATE " + StoreConst.TABLENAME + " SET " +
	 * StoreConst.RADIOBN + " = null, " + StoreConst.RADIOGRP + " = null, " +
	 * StoreConst.SPINNER + " = null, " + StoreConst.DATEPICKER + " = null, " +
	 * StoreConst.CALENDARVIEW + " = null, " + StoreConst.CHECKBOX +
	 * " = null WHERE " + StoreConst.UNAME + " = '" + currUser + "'");
	 * db.close(); }
	 * 
	 * public void addDate(String s) { if (currUser != null) {
	 * 
	 * SQLiteDatabase db = this.getWritableDatabase(); db.execSQL("UPDATE " +
	 * StoreConst.TABLENAME + " SET " + StoreConst.DATEPICKER + " = '" + s +
	 * "' WHERE " + StoreConst.UNAME + " = '" + currUser + "'"); db.close(); //
	 * Closing database connection } }
	 * 
	 * public void addCheck(String s) { if (currUser != null) { SQLiteDatabase
	 * db = this.getWritableDatabase(); db.execSQL("UPDATE " +
	 * StoreConst.TABLENAME + " SET " + StoreConst.CHECKBOX + " = '" + s +
	 * "' WHERE " + StoreConst.UNAME + " = '" + currUser + "'"); db.close(); } }
	 * 
	 * public void addRadioBn(String s) { if (currUser != null) { SQLiteDatabase
	 * db = this.getWritableDatabase(); db.execSQL("UPDATE " +
	 * StoreConst.TABLENAME + " SET " + StoreConst.RADIOBN + " = '" + s +
	 * "' WHERE " + StoreConst.UNAME + " = '" + currUser + "'"); db.close(); } }
	 * 
	 * public void addRadioGrp(String s) { if (currUser != null) {
	 * SQLiteDatabase db = this.getWritableDatabase(); db.execSQL("UPDATE " +
	 * StoreConst.TABLENAME + " SET " + StoreConst.RADIOGRP + " = '" + s +
	 * "' WHERE " + StoreConst.UNAME + " = '" + currUser + "'"); db.close(); } }
	 * 
	 * public void addSpinner(String s) { if (currUser != null) { SQLiteDatabase
	 * db = this.getWritableDatabase(); db.execSQL("UPDATE " +
	 * StoreConst.TABLENAME + " SET " + StoreConst.SPINNER + " = '" + s +
	 * "' WHERE " + StoreConst.UNAME + " = '" + currUser + "'"); db.close(); } }
	 * 
	 * public void addCal(String s) { if (currUser != null) { SQLiteDatabase db
	 * = this.getWritableDatabase(); db.execSQL("UPDATE " + StoreConst.TABLENAME
	 * + " SET " + StoreConst.CALENDARVIEW + " = '" + s + "' WHERE " +
	 * StoreConst.UNAME + " = '" + currUser + "'"); db.close(); } }
	 */
}

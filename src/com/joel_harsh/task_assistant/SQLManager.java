package com.joel_harsh.task_assistant;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
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

	public static boolean istaskPresent(String tName) {
		SQLiteDatabase db = sqlObj.getWritableDatabase();
		long r = DatabaseUtils.longForQuery(db, "SELECT count(*) FROM "
				+ StoreConst.TABLENAME + " WHERE " + StoreConst.NAME + " = '"
				+ tName + "'", null);
		db.close();
		if (r > 0)
			return true;
		else
			return false;

	}

	public static void newTask(String tName, String tDate, String tPr) {

		SQLiteDatabase db = sqlObj.getWritableDatabase();
		// Inserting Row
		db.execSQL("INSERT INTO " + StoreConst.TABLENAME + "('"
				+ StoreConst.NAME + "', '" + StoreConst.DATE + "', '"
				+ StoreConst.PR + "', '" + StoreConst.STATUS + "')  VALUES ('"
				+ tName + "', '" + tDate + "', '" + tPr + "', 0);");
		db.close();

	}

	public Cursor getTaskByName(int status) {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(StoreConst.TABLENAME, null, StoreConst.STATUS
				+ "= " + status, null, null, null, " " + StoreConst.NAME
				+ " ASC");

		// Cursor cursor = db.rawQuery("SELECT * FROM " + StoreConst.TABLENAME,
		// null);
		// / + " WHERE " + StoreConst.STATUS + "= " + status
		// + " ORDER BY "
		// + StoreConst.NAME + " ASC", null);
		// db.close();
		return cursor;
	}

	public Cursor getTaskByDate(int status) {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(StoreConst.TABLENAME, null, StoreConst.STATUS
				+ "= " + status, null, null, null, StoreConst.DATE);
		// db.close();
		return cursor;
	}

	public Cursor getTaskByPr(int status) {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db
				.query(StoreConst.TABLENAME,
						null,
						StoreConst.STATUS + "= " + status,
						null,
						null,
						null,
						"CASE "
								+ StoreConst.PR
								+ " WHEN 'High' THEN 0 WHEN 'Medium' THEN 1 WHEN 'Low' THEN 2 END");
		// db.close();
		return cursor;
	}

	public void clearDataBase() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DELETE FROM " + StoreConst.TABLENAME);
		db.close();
	}

	public long getTasksDoneCount() {

		SQLiteDatabase db = this.getReadableDatabase();
		long r = DatabaseUtils.longForQuery(db,
				"SELECT count(*) FROM " + StoreConst.TABLENAME + " WHERE "
						+ StoreConst.STATUS + " = 1", null);
		db.close();
		return r;
	}

	public long getTasksLeftCount() {

		SQLiteDatabase db = this.getReadableDatabase();
		long r = DatabaseUtils.longForQuery(db,
				"SELECT count(*) FROM " + StoreConst.TABLENAME + " WHERE "
						+ StoreConst.STATUS + " = 0", null);
		db.close();
		return r;
	}

	public long getTasksDoneOnGivenDayCount(String s) {

		SQLiteDatabase db = this.getReadableDatabase();
		long r = DatabaseUtils.longForQuery(db, "SELECT count(*) FROM "
				+ StoreConst.TABLENAME + " WHERE " + StoreConst.STATUS
				+ " = 1 AND " + StoreConst.DATE + " = '" + s + "'", null);
		db.close();
		return r;
	}

	public long getTasksLeftOnGivenDayCount(String s) {

		SQLiteDatabase db = this.getReadableDatabase();
		long r = DatabaseUtils.longForQuery(db, "SELECT count(*) FROM "
				+ StoreConst.TABLENAME + " WHERE " + StoreConst.STATUS
				+ " = 0 AND " + StoreConst.DATE + " = '" + s + "'", null);
		db.close();
		return r;
	}

	public void updateDate(String s, String d) {
		SQLiteDatabase db2 = this.getWritableDatabase();
		db2.execSQL("UPDATE " + StoreConst.TABLENAME + " SET "
				+ StoreConst.DATE + " = '" + d + "' WHERE " + StoreConst.NAME
				+ " = '" + s + "'");
		db2.close();

	}

	public void updatePR(String s, String p) {
		SQLiteDatabase db2 = this.getWritableDatabase();
		db2.execSQL("UPDATE " + StoreConst.TABLENAME + " SET " + StoreConst.PR
				+ " = '" + p + "' WHERE " + StoreConst.NAME + " = '" + s + "'");
		db2.close();

	}

	public void markAsDone(String s) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("UPDATE " + StoreConst.TABLENAME + " SET "
				+ StoreConst.STATUS + " = " + 1 + " WHERE " + StoreConst.NAME
				+ " = '" + s + "'");
		db.close();

	}

	public void deleteTask(String s) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DELETE FROM " + StoreConst.TABLENAME + " WHERE "
				+ StoreConst.NAME + " = '" + s + "'");
		db.close();
	}

	public static void deleteALL() { // DANGER!! TESTING ONLY!!
		SQLiteDatabase db = sqlObj.getWritableDatabase();
		db.execSQL("DELETE FROM " + StoreConst.TABLENAME);
		db.close();
	}
}
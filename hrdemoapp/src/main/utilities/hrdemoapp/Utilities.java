package hrdemoapp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utilities {
	public static String getTimeStamp(){
	//	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMMddHHmmss");
		String timestamp = new SimpleDateFormat("yyyyMMMddHHmmss").format(new Timestamp(System.currentTimeMillis()));
		return timestamp;
	}
}

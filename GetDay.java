package beans;

import java.util.Calendar;
import java.util.Date;

public class GetDay {
	
	public Date getLastMonday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month, 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 5 ) );
		   return cal.getTime();
	}
	
	public Date getLastTuesday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month, 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 4 ) );
		   return cal.getTime();
	}
	
	public Date getLastWednesday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month , 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 3 ) );
		   return cal.getTime();
	}
	public Date getLastThursday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month, 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 2 ) );
		   return cal.getTime();
	}
	
	public Date getLastFriday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month, 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
		   return cal.getTime();
	}
	
	public Date getLastSaturday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month , 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 ) );
		   return cal.getTime();
	}
	
	public Date getLastSunday( int month, int year ) 
	{
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month , 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 6 ) );
		   return cal.getTime();
	}
}

package com.zara.prices.utils;

import java.util.Date;

import java.text.SimpleDateFormat;  

public class Utils {

    public static final String FORMAT_PATTERN = "dd-MM-yyyy HH:mm:ss";
    
    /** 
     * Method to change from string date to date
     * @param date
     * @return Date
     * @throws Exception
     */
    public static Date getDatefromString(String date) throws Exception{
        
        SimpleDateFormat formatDate = new SimpleDateFormat(FORMAT_PATTERN);
        return formatDate.parse(date);
    }

    
    /** 
     * Method to change from date to String
     * @param date
     * @return String
     */
    public static String getStringfromDate(Date date){
        
        SimpleDateFormat formatDate = new SimpleDateFormat(FORMAT_PATTERN);
        return formatDate.format(date);
    }

}

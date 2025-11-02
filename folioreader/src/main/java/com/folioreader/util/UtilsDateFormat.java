package com.folioreader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class UtilsDateFormat {

    private static boolean isFarsi() {
        return Locale.getDefault().getLanguage().equalsIgnoreCase("fa");
    }

    private static CalendarTool calendarTool;


    /**
     * get elapsed time between given time and current time
     * or can get date
     *
     * @param millis
     * @return passed time
     */


    public static String getDateTime(String date, DateConvertType convertType) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        try {
            return getDateTime(sdf.parse(date), convertType);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDateTime(Date date, DateConvertType convertType) {

        if (date == null)
            date = new Date();

        SimpleDateFormat sdf;
        if (calendarTool == null)
            calendarTool = new CalendarTool();
        switch (convertType) {
            case DATE:
                calendarTool.setGregorianDate(date);
                return calendarTool.getIranianDate();
            case DAY_MONTH_NAME_YEAR:
                calendarTool.setGregorianDate(date);
                return calendarTool.getIranianDay() + " " + calendarTool.getIranianMonthStr() + " " + calendarTool.getIranianYear();
            case TIME:
                sdf = new SimpleDateFormat("HH:mm", Locale.US);
                return sdf.format(date);
            case DATE_TIME:
            default:
                sdf = new SimpleDateFormat("hh:mm", Locale.US);
                calendarTool.setGregorianDate(date);
                return calendarTool.getIranianDate() + "  " + sdf.format(date);
        }

    }


    public static long passedMonth(long date) {
        try {
            Date eventDate = new Date(date);
            Date currentDate = new Date();
            if (!currentDate.after(eventDate)) {
                long diff = currentDate.getTime() - eventDate.getTime();
                return diff / (30 * 24 * 60 * 60 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long passedDays(long date) {
        try {
            Date eventDate = new Date(date);
            Date currentDate = new Date();
            if (!eventDate.after(currentDate)) {
                long diff = currentDate.getTime() - eventDate.getTime();
                return diff / (24 * 60 * 60 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long passedHours(long date) {
        try {
            Date eventDate = new Date(date);
            Date currentDate = new Date();
            if (!eventDate.after(currentDate)) {
                long diff = currentDate.getTime() - eventDate.getTime();
                return diff / (60 * 60 * 1000);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static long passedMinutes(long date) {
        try {
            Date eventDate = new Date(date);
            Date currentDate = new Date();
            if (!eventDate.after(currentDate)) {
                long diff = currentDate.getTime() - eventDate.getTime();
                return diff / (60 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static long passedSeconds(long date) {
        try {
            Date eventDate = new Date(date);
            Date currentDate = new Date();
            if (!eventDate.after(currentDate)) {
                long diff = currentDate.getTime() - eventDate.getTime();
                return diff / 1000;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public enum DateConvertType {
        DATE_TIME,
        DATE,
        DAY_MONTH_NAME_YEAR,
        TIME
    }

}

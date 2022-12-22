package com.glady.gladyTest.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {

    public static Date calculateEndDate(String type, Date startDate) throws ParseException {
        if ("GIFT".equalsIgnoreCase(type)) {
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(Calendar.DATE, 365);
            return c.getTime();
        }
        if ("MEAL".equalsIgnoreCase(type)) {
            Calendar calender = Calendar.getInstance();
            calender.setTime(startDate);
            Integer year = calender.get(Calendar.YEAR) + 1;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            calender.setTime(simpleDateFormat.parse("01/02/" + year));
            int endfeb = calender.getActualMaximum(Calendar.DATE);
            return simpleDateFormat.parse(endfeb + "/02/" + year);
        }
        return new Date();
    }
}

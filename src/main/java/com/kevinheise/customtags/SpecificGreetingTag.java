package com.kevinheise.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class SpecificGreetingTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out   = getJspContext().getOut();
        int currentHour = LocalTime.now().getHour();

        LocalDate currentDate  = LocalDate.now();
        LocalDate christmas    = LocalDate.of(2018, 12, 25);

        if (currentHour >= 0 && currentHour < 12) {
            out.println("Good Morning!");
        } else if (currentHour >= 12 && currentHour < 16 ) {
            out.println("Good Afternoon!");
        } else if (currentHour >= 16) {
            out.println("Good Evening!");
        }

        out.println("<br />");

        out.println(currentDate.until(christmas).getMonths() + " months and "
                + currentDate.until(christmas).getDays() + " days until Christmas!");
    }
}

package sample.view;
import javafx.scene.control.DatePicker;

import java.util.Date;

public class FDDatePicker extends DatePicker{
    static  Date defaultDate = new Date(0,0,0);

    public Date getBirthDateValue(){
        if (getValue() != null) {
            return new Date(getValue().getYear(), getValue().getMonth().ordinal(), getValue().getDayOfMonth());
        } else{
            return defaultDate;
        }
    }

    static public Date getDefaultDate(){
        return defaultDate;
    }
}

package Task;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return getDateTime().getYear() == dateForCheck.getYear()
                && getDateTime().getMonth() == dateForCheck.getMonth()
                && getDateTime().getDayOfYear() == dateForCheck.getDayOfYear();
    }
}

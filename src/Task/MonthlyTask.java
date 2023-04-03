package Task;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }
    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return getDateTime().getDayOfMonth() == dateForCheck.getDayOfMonth();
    }

}

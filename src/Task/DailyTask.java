package Task;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return true;
    }
}

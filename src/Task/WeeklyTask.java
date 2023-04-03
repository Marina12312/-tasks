package Task;



import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description){
        super(title, type ,dataTime,description);
    }

public boolean appearsln(LocalDate dateForCheck) {
        return (getDateTime().getDayOfWeek()== dateForCheck.getDayOfWeek());
}
}

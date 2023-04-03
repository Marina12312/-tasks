package Task;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private String title;
    private Type type;
    private final LocalDateTime dateTime;
    private String description;
    private int id;
    private static int idCenerator=1;

    public Task(String title,
                Type type,
                LocalDateTime dateTime,
                String description) {
        setTitle(title);
        this.type=type;
        this.dateTime=dateTime;
        this.id=idCenerator++;
        setDescription(description);

    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        try {
            checkSetTitle(title);
        } catch (IncorrectArgumentException e){
            this.title="название задачи неверное!";
        }
    }
    public  void checkSetTitle(String title) throws IncorrectArgumentException {
        if (title==null || title.isEmpty() || title.isBlank()){
            throw new IncorrectArgumentException(title);}
            this.title=title;
        }

    public void setDescription(String description) {
        try {
            checkSetDescription(description);
        } catch (IncorrectArgumentException e){
        this.description = "Описание задачи не заданно";
    }
}
    public void checkSetDescription(String description) throws IncorrectArgumentException {
    if (description == null || description.isEmpty() || description.isBlank()) {
        throw new IncorrectArgumentException(description);
    }
    this.description = description;
}

    @Override
    public String toString() {
        return
                "Задача: " + title +
                "Тип задачи: " + type +
                "Дата : " + dateTime +
                "Описание '" + description  +
                "№ " + id ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(type, task.type) && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dateTime, description, id);
    }

    public abstract boolean appearsln(LocalDate dateForCheck);
}

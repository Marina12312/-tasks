package Task;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(String massage){
        super(massage);
    }

    @Override
    public String toString() {
        return "TaskNotFoundException{}"+ super.toString();
    }
}

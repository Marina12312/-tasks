package Task;

public class IncorrectArgumentException  extends  Exception{
    private String argument;


    @Override
    public String toString() {
        return argument + "Задан неверно!";
    }

    public String getArgument() {
        return argument;
    }

    public IncorrectArgumentException(String argument){
        this.argument=argument;
    }
}

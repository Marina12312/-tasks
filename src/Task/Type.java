package Task;

public enum Type {
    WORK("рабочая"),
    PERSONAL("личная"),
    DEFAULT("Дефолт");

    private final String type;

    @Override
    public String toString() {
        return  type ;
    }

    public String getType() {
        return type;
    }

    Type (String type){
        this.type=type;
    }

}

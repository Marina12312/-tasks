package Task;

public enum Type implements java.lang.reflect.Type {
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

    @Override
    public String getTypeName() {
        return java.lang.reflect.Type.super.getTypeName();
    }
}

package lotto.model;

public enum TicketType {
    AUTO("자동"),
    MANUAL("수동");

    private final String typeName;

    TicketType(String typeName) {
        this.typeName = typeName;
    }

    public String getTicketTypeName(){
        return this.typeName;
    }
}

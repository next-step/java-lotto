package lotto.domain.ticket;

public enum LottoTicketType {
    AUTO("자동"), MANUAL("수동");

    private final String type;

    LottoTicketType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

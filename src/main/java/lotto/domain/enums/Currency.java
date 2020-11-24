package lotto.domain.enums;

public enum Currency {
    WON("원");

    private String description;

    Currency(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

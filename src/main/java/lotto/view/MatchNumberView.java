package lotto.view;

public enum MatchNumberView {
    THREE("3개 일치 (5000원)- "),
    FOUR("4개 일치 (50000원)- "),
    FIVE("5개 일치 (1500000원)- "),
    SIX("6개 일치 (2000000000원)- ");

    private final String message;

    MatchNumberView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

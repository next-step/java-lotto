package lotto;

public enum WinningStatics {
    THREE("3개 일치 (5000원)- %s개"),
    FOUR("4개 일치 (50000원)- %s개"),
    FIVE("5개 일치 (1500000원)- %s개"),
    BONUS("5개 일치, 보너스 볼 일치(30000000원)- %s개"),
    ALL("6개 일치 (2000000000원)- %s개")
    ;
    private String description;


    WinningStatics(String description) {
        this.description = description;
    }

    public String getResult(int matchCount) {
        return String.format(this.description, matchCount);
    }
}

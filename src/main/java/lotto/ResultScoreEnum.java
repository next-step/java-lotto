package lotto;


import java.util.Arrays;
import java.util.Optional;

public enum ResultScoreEnum {

    FIRST(6, false, 2000000000, "6개 일치 (2000000000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5, false, 150000, "5개 일치 (150000원)"),
    FOURTH(4, false,50000, "4개 일치 (50000원)"),
    FIFTH(3, false,5000, "3개 일치 (5000원)"),
    MISS(0,false, 0, "0개 일치 (0원)");

    private String printResult;
    private int countOfMatch;
    private int winningMoney;
    boolean matchBonus;

    ResultScoreEnum(int countOfMatch, boolean matchBonus, int winningMoney, String printResult) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.printResult = printResult;
        this.matchBonus = matchBonus;
    }

    public void printResult(int wonCount) {
        System.out.println(printResult + "-" + wonCount + "개");
    }

    public int getWonMoney(int wonCount) {
        return winningMoney * wonCount;
    }

    public static ResultScoreEnum valueOf(int countOfMatch, boolean matchBonus) {
         Optional<ResultScoreEnum> result = Arrays.stream(values())
                .filter(resultScoreEnum -> resultScoreEnum.countOfMatch == countOfMatch && resultScoreEnum.matchBonus == matchBonus)
                .findFirst();

        return result.orElseGet(()-> ResultScoreEnum.MISS);
    }
}

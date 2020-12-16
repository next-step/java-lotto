package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinResults {

    private List<WinResult> winResults;

    public WinResults(List<WinResult> winResults) {
        this.winResults = winResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinResults that = (WinResults) o;
        return Objects.equals(winResults, that.winResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winResults);
    }

    public Money getWinningMoneySum() {
        return Money.of(this.winResults.stream()
                .map(WinResult::getWinningMoney)
                .reduce(0, Integer::sum));
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(WinResult.values())
                .forEach(item -> {
                    stringBuilder.append(getResult(item));
                    stringBuilder.append(System.lineSeparator());
                });
        return stringBuilder.toString();
    }

    private String getResult(WinResult winResult) {
        if (winResult == WinResult.MISS) {
            return "";
        }
        long count = this.winResults.stream().filter(item -> item == winResult).count();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winResult.getCountOfMatch());
        stringBuilder.append("개 일치");
        stringBuilder.append(" ( " + winResult.getWinningMoney() + "원) ");
        stringBuilder.append(" - " + count + "개");
        return stringBuilder.toString();
    }

}

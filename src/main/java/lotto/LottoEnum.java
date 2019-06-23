package lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoEnum {

    Winner3("3개 일치 ", Arrays.asList(5000, 0)),
    Winner4("4개 일치 ", Arrays.asList(50000, 1)),
    Winner5("5개 일치 ", Arrays.asList(1500000, 2)),
    Winner6("6개 일치 ", Arrays.asList(20000000, 3)),
    EMPTY("", Arrays.asList(0, 0));

    private String winnerCount;
    private List<Integer> summary;

    LottoEnum(String winnerCount, List<Integer> summary) {
        this.winnerCount = winnerCount;
        this.summary = summary;
    }

    public static LottoEnum findByPrice(String winnerCount) {
        return Arrays.stream(LottoEnum.values())
                .filter(itemarray -> itemarray.hasDataGroup(winnerCount))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasDataGroup(String winnerCount) {
        return this.winnerCount.contains(winnerCount);
    }

    public int price() {
        return summary.get(0);
    }

    public int summaryNumber(){
        return summary.get(1);
    }

}

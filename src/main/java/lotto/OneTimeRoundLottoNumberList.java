package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OneTimeRoundLottoNumberList {
    List<Integer> lottoNumberList;

    public OneTimeRoundLottoNumberList(List<Integer> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    @Override
    public String toString() {
        String format = lottoNumberList.stream().
                map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + format +']';
    }

    public void runWinner(LottoWinner lottoWinner) {
        int matchingCount = lottoWinner.findMachingCount(lottoNumberList);
        lottoWinner.updateMatchingCount(matchingCount);
    }
}

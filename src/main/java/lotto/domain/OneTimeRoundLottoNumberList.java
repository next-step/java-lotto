package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class OneTimeRoundLottoNumberList {
    private List<Integer> lottoNumberList;

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

    public void searchWinningCount(LottoWinner lottoWinner) {
        int matchingCount = lottoWinner.diffLottoAndWinningLotto(lottoNumberList);
        lottoWinner.recordWinningCount(matchingCount);
    }
}

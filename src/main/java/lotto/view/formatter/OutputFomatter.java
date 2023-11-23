package lotto.view.formatter;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.Profit;

public class OutputFomatter {

    public int toLottoCount(LottoCount lottoCount) {
        return lottoCount.getLottoCount();
    }

    public String toLotto(Lotto lotto) {
        List<LottoNumber> rawLottoNumbers = lotto.getLottoNumbers();
        List<String> lottoNumbers = rawLottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.getLottoNumber() + "")
                .collect(Collectors.toList());
        return String.join(", ", lottoNumbers);
    }

    public String toCountOfMatchMessage(Entry<Rank, Integer> rawPrizeDetail) {
        int countOfMatch = rawPrizeDetail.getKey().getCountOfMatch();

        if (rawPrizeDetail.getKey() == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼", countOfMatch);
        }
        return String.format("%d개", countOfMatch);
    }

    public int toWinningMoney(Entry<Rank, Integer> rawPrizeDetail) {
        return rawPrizeDetail.getKey().getWinningMoney();
    }

    public int toPrizeCount(Entry<Rank, Integer> rawPrizeDetail) {
        return rawPrizeDetail.getValue();
    }

    public double toProfit(Profit profit) {
        return profit.getProfit();
    }
}

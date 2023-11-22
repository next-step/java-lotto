package lotto.view.formatter;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
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

    public int toMatchingCount(Entry<Prize, Integer> rawPrizeDetail) {
        return rawPrizeDetail.getKey().getMatchingCount();
    }

    public int toPrizeAmount(Entry<Prize, Integer> rawPrizeDetail) {
        return rawPrizeDetail.getKey().getPrizeAmount();
    }

    public int toPrizeCount(Entry<Prize, Integer> rawPrizeDetail) {
        return rawPrizeDetail.getValue();
    }

    public double toProfit(Profit profit) {
        return profit.getProfit();
    }
}

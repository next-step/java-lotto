package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoSheetResults {
    private final Map<LottoNumberMatchCount, LottoSheetMatchCount> lottoSheetResults;

    public static final Map<LottoNumberMatchCount, LottoCashPrize> LOTTO_CASH_PRIZES = new HashMap<>(){{
        put(new LottoNumberMatchCount(3), new LottoCashPrize(5_000));
        put(new LottoNumberMatchCount(4), new LottoCashPrize(50_000));
        put(new LottoNumberMatchCount(5), new LottoCashPrize(1_500_000));
        put(new LottoNumberMatchCount(6), new LottoCashPrize(2_000_000_000));
    }};

    public LottoSheetResults(Map<LottoNumberMatchCount, LottoSheetMatchCount> lottoSheetResults) {
        this.lottoSheetResults = lottoSheetResults;
    }

    public static LottoSheetResults create(WinningLottoNumbers winningLottoNumbers, List<LottoSheet> lottoSheets) {
        Map<LottoNumberMatchCount, LottoSheetMatchCount> lottoSheetResults = new HashMap<>();

        for (LottoSheet lottoSheet : lottoSheets) {
            int count = winningLottoNumbers.getMatchedNumberCount(lottoSheet.getLottoNumbers());
            LottoSheetMatchCount lottoSheetMatchCount = lottoSheetResults.getOrDefault(
                            new LottoNumberMatchCount(count), new LottoSheetMatchCount())
                    .add();
            lottoSheetResults.put(new LottoNumberMatchCount(count), lottoSheetMatchCount);
        }

        return new LottoSheetResults(lottoSheetResults);
    }

    public Map<LottoNumberMatchCount, LottoSheetMatchCount> getValue() {
        return new HashMap<>(this.lottoSheetResults);
    }
}

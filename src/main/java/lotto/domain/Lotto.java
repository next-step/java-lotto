package lotto.domain;

import java.util.List;

public class Lotto {
    public static int LOTTO_NUMBER_COUNT = 6;
    public static int MIN_LOTTO_NUMBER = 1;
    public static int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumberList;

    private Lotto(LottoNumberGeneratingStrategy lottoNumberGeneratingStrategyStub) {
        this.lottoNumberList = lottoNumberGeneratingStrategyStub.lottoNumbers();
    }

    public static Lotto valueOf(LottoNumberGeneratingStrategy lottoNumberGeneratingStrategyStub) {
        return new Lotto(lottoNumberGeneratingStrategyStub);
    }

    public long numberOfMatch(WinningNumbers winningNumbers) {
        return lottoNumberList.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}

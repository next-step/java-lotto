package lotto.domain;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.shuffle;

public class Lotto {
    private static final Integer LOTTO_NUMBER_MIN_INDEX = 0;
    private static final Integer LOTTO_NUMBER_MAX_INDEX = 6;

    private LottoResult lottoResult;

    public Lotto() {
    }

    public Lotto(List<Integer> lottoNumberList) {
        this(new LottoResult(lottoNumberList));
    }

    public Lotto(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoResult.getLottoNumbers();
    }

    public Rank getRank(LottoResult winnerLottoResult) {
        return lottoResult.getMatchCount(winnerLottoResult);
    }

    public Lotto pickAuto(List<Integer> numberList) {
        shuffle(numberList);
        List<Integer> lottoNumberList = numberList.subList(LOTTO_NUMBER_MIN_INDEX, LOTTO_NUMBER_MAX_INDEX);
        lottoNumberList.sort(Comparator.comparing(Integer::intValue));
        this.lottoResult = new LottoResult(lottoNumberList);
        return this;
    }

}

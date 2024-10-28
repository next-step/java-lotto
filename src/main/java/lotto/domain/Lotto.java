package lotto.domain;

import lotto.random.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int MINIMUM_LOTTO_NUMBE = 0;
    public static final int MAXIMUM_LOTTO_NUMBER = 5;
    private final List<LottoNumbers> lottoNumbersList;

    public static Lotto initAllRoundLottoNumbers(LottoGenerator lottoGenerator, int tryCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottoNumbersList.add(new LottoNumbers(lottoGenerator.executeStrategy()));
        }
        return new Lotto(lottoNumbersList);
    }

    public Lotto(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public List<List<Integer>> totalRoundLottoNumberList() {
        List<List<Integer>> totalNumbersList = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            totalNumbersList.add(lottoNumbers.convertIntLottoNumbersList());
        }
        return totalNumbersList;
    }

    public List<Integer> lottoRankList(LottoNumbers winningLottoNumbers) {
        return lottoNumbersList.stream()
                .mapToInt(lottoNumbers -> winningLottoNumbers.lottoRank(lottoNumbers.getLottoNumberList()))
                .filter(lottoRank -> lottoRank > MINIMUM_LOTTO_NUMBE && lottoRank < MAXIMUM_LOTTO_NUMBER)
                .boxed().collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lottoNumbersList, that.lottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbersList);
    }
}

package lotto.domain;

import lotto.LottoRank;
import lotto.random.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

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

    public List<LottoNumbers> totalRoundLottoNumberList() {
        return lottoNumbersList;
    }

    public LottoResult updateWinningRankList(WinningLotto winningLotto) {
        return new LottoResult(lottoRankList(winningLotto));
    }

    public List<LottoRank> lottoRankList(WinningLotto winningLotto) {
        List<LottoRank> list = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            LottoRank lottoRank = winningLotto.lottoRank(lottoNumbers);
            if (lottoRank != LottoRank.NONE) {
                list.add(lottoRank);
            }
        }
        return list;
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

package lotto.domain;

import lotto.LottoRank;
import lotto.random.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumbers> lottoNumbersList;
    private LottoResult lottoResult;

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

    public void updateWinningRankList(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        lottoResult = new LottoResult(lottoRankList(winningLottoNumbers, bonusNumber));
    }

    public List<LottoRank> lottoRankList(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        return lottoNumbersList.stream()
                .map(lottoNumbers -> winningLottoNumbers.lottoRank(lottoNumbers, bonusNumber))
                .filter(lottoRank -> lottoRank != LottoRank.NONE).collect(Collectors.toList());
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double calculateMarginPercent(int purchaseAmount) {
        return lottoResult.calculateMarginPercent(purchaseAmount);
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

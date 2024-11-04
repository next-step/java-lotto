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
        return initAllRoundLottoNumbers(new Lotto(new ArrayList<>()), lottoGenerator, tryCount);
    }

    public static Lotto initAllRoundLottoNumbers(Lotto manualLotto, LottoGenerator lottoGenerator, int tryCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        insertManualLotto(manualLotto, lottoNumbersList);
        insertRandomLotto(lottoGenerator, tryCount, lottoNumbersList);
        return new Lotto(lottoNumbersList);
    }

    public Lotto(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    private static void insertRandomLotto(LottoGenerator lottoGenerator, int tryCount, List<LottoNumbers> lottoNumbersList) {
        for (int i = 0; i < tryCount; i++) {
            lottoNumbersList.add(new LottoNumbers(lottoGenerator.executeStrategy()));
        }
    }

    private static void insertManualLotto(Lotto manaulLotto, List<LottoNumbers> lottoNumbersList) {
        if (!manaulLotto.isEmpty()) {
            lottoNumbersList.addAll(manaulLotto.totalRoundLottoNumberList());
        }
    }

    public boolean isEmpty() {
        return lottoNumbersList.isEmpty();
    }

    public List<LottoNumbers> totalRoundLottoNumberList() {
        return lottoNumbersList;
    }

    public LottoResult updateWinningRankList(WinningLotto winningLotto) {
        return new LottoResult(lottoRankList(winningLotto));
    }

    public List<LottoRank> lottoRankList(WinningLotto winningLotto) {
        return lottoNumbersList.stream()
                .map(winningLotto::lottoRank)
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .collect(Collectors.toList());
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

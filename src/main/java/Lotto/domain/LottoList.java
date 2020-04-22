package Lotto.domain;

import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    private LottoList(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoList of(final List<Lotto> lottoList) {
        return new LottoList(lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public long manualLottoCount() {
        return lottoList.stream().filter(Lotto::isManualLotto).count();
    }

    public long autoLottoCount() {
        return lottoList.stream().filter(Lotto::isAutoLotto).count();
    }

    public LottoResult getResult(final WinningLotto winningLotto) {
        final LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoList) {
            lottoResult.insertResult(lotto.getWinningTypeWithWinningNumbers(winningLotto));
        }
        return lottoResult;
    }
}

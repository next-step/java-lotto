package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.Winning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {

    private static final int RANGE_INITIAL = 0;

    public Lottos issueLottos(int count, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(RANGE_INITIAL, count)
                .forEach(v -> lottos.add(Lotto.of(lottoGenerator)));

        return new Lottos(lottos);
    }

    public void scratchLottos(Lottos lottos, Winning winning) {
        for (Lotto lotto : lottos.getLottos()) {
            scratchLottos(lotto, winning);
        }
        lottos.setStatistics();
    }

    public void scratchLottos(Lotto lotto, Winning winning) {
        LottoRank lottoRank = calculateLottoRank(lotto, winning);
        lotto.scratchLotto(lottoRank);
    }

    LottoRank calculateLottoRank(Lotto lotto, Winning winning) {
        int correctCount = (int) winning.getWinning().stream()
                .filter(num -> lotto.getLotto().contains(num))
                .count();

        return LottoRank.of(correctCount);
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private LottoGenerator() {
        throw new UnsupportedOperationException("Util 클래스의 인스턴스는 생성할 수 없습니다.");
    }

    public static Lottos generateLottos(LottoMoney lottoMoney, final CandidateStrategy candidateStrategy) {
        final List<Lotto> lottosContent = new ArrayList<>();
        while (lottoMoney.isPayableOneLotto()) {
            lottoMoney = lottoMoney.payOneLotto();
            lottosContent.add(generateOne(candidateStrategy));
        }

        return new Lottos(lottosContent);
    }

    public static Lotto generateOne(CandidateStrategy candidateStrategy) {
        final List<Integer> candidates = candidateStrategy.generateCandidates();

        return new Lotto(candidates.subList(0, Lotto.REQUIRED_LOTTO_NUMBER_COUNT));
    }


    public static void checkProperLottoCount(final LottoMoney lottoMoney, final LottoCount lottoCount) {
        if (!lottoMoney.isPayable(lottoCount.toTotalLottoPrice())) {
            throw new IllegalArgumentException("구매 가능한 로또 개수를 초과했습니다. 잔액: " + lottoMoney.getValue());
        }
    }
}

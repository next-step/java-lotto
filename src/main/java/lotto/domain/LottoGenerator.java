package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private LottoGenerator() {
        throw new UnsupportedOperationException("Util 클래스의 인스턴스는 생성할 수 없습니다.");
    }

    public static List<List<Integer>> generateLottoContents(LottoMoney lottoMoney, final CandidateStrategy candidateStrategy) {
        final List<List<Integer>> lottoContents = new ArrayList<>();
        while (lottoMoney.isPayable()) {
            lottoMoney = lottoMoney.payLotto();
            lottoContents.add(generateOne(candidateStrategy));
        }

        return lottoContents;
    }

    public static List<Integer> generateOne(CandidateStrategy candidateStrategy) {
        final List<Integer> candidates = candidateStrategy.generateCandidates();

        return candidates.subList(0, Lotto.REQUIRED_LOTTO_NUMBER_COUNT);
    }


}

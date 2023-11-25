package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoSeller implements Seller {
    private final LottoCountSummary lottoCountSummary;
    private final Random random;

    private LottoSeller(LottoCountSummary lottoCountSummary, Random random) {
        this.lottoCountSummary = lottoCountSummary;
        this.random = random;
    }

    public static LottoSeller from(LottoCountSummary lottoCountSummary) {
        return new LottoSeller(lottoCountSummary, new Random());
    }

    @Override
    public Lottos generateAutoLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int presentLottoCount = 0;

        while (lottoCountSummary.isLessThanAutoLottoCount(presentLottoCount)) {
            lottos.add(generateLotto());
            presentLottoCount++;
        }
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        Set<Integer> lottoNumbers = generateUniqueNumbers();
        return Lotto.from(sortLotto(lottoNumbers));
    }

    private Set<Integer> generateUniqueNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (isWithinLottoCountLimit(lottoNumbers)) {
            lottoNumbers.add(random.nextInt(LottoNumber.MAX_LOTTO_NUMBER) + 1);
        }
        return lottoNumbers;
    }

    private List<Integer> sortLotto(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isWithinLottoCountLimit(Set<Integer> lottoNumbers) {
        return lottoNumbers.size() < Lotto.LOTTO_NUMBER_COUNT;
    }
}

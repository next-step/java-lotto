package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoSeller implements Seller {
    private final LottoCount lottoCount;
    private final Random random;

    private LottoSeller(LottoCount lottoCount, Random random) {
        this.lottoCount = lottoCount;
        this.random = random;
    }

    public static LottoSeller from(LottoCount lottoCount) {
        return new LottoSeller(lottoCount, new Random());
    }

    @Override
    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int presentLottoCount = 0;

        while (lottoCount.isLessThanCount(presentLottoCount)) {
            lottos.add(generateLotto());
            presentLottoCount++;
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        Set<Integer> lottoNumbers = generateUniqueNumbers();
        return Lotto.from(sortLotto(lottoNumbers));
    }

    private Set<Integer> generateUniqueNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        boolean isValidLotto = true;

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

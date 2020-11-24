package study.lotto.dispenser;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoDispenser {

    private static final LottoDispenser instance = new LottoDispenser();

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoDispenser() {
    }

    public static LottoDispenser getInstance() {
        return instance;
    }

    public Lottos auto(int numberOfPurchases) {

        initLottoNumbers();

        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfPurchases; count++) {
            lottos.add(new Lotto(getLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    private void initLottoNumbers() {
        if (lottoNumbers.isEmpty()) {
            createLottoNumbers();
        }
    }

    private void createLottoNumbers() {
        for (int lottoNumber = LottoNumber.MIN_LOTTO_NUMBER
                ; lottoNumber <= LottoNumber.MAX_LOTTO_NUMBER
                ; lottoNumber++) {
            lottoNumbers.add(LottoNumber.of(lottoNumber));
        }
    }

    private Set<LottoNumber> getLottoNumbers() {
        // 섞기
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }

    public Lotto manual(List<String> parsedLottoNumbers) {
        return new Lotto(toLottoNumbers(parsedLottoNumbers));
    }

    public Set<LottoNumber> toLottoNumbers(List<String> parsedLottoNumbers) {
        return parsedLottoNumbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

}

package study.lotto.dispenser;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDispenser {

    private static final LottoDispenser instance = new LottoDispenser();
    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private  LottoDispenser() {
        for (int lottoNumber = LottoNumber.MIN_LOTTO_NUMBER
                 ; lottoNumber < LottoNumber.MAX_LOTTO_NUMBER
                 ; lottoNumber++) {
            this.lottoNumbers.add(LottoNumber.of(lottoNumber));
        }
    }

    public static LottoDispenser getInstance() {
        return instance;
    }

    public static Lottos auto(int numberOfPurchases) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfPurchases; count++) {
            lottos.add(new Lotto(getLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    private static List<LottoNumber> getLottoNumbers() {
        // 섞기
        Collections.shuffle(lottoNumbers);

        return new ArrayList<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }

    public static Lotto manual(List<String> parsedLottoNumbers) {
        return new Lotto(toLottoNumbers(parsedLottoNumbers));
    }

    public static List<LottoNumber> toLottoNumbers(List<String> parsedLottoNumbers) {
        return parsedLottoNumbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

}

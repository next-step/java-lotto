package study.lotto;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDispenser {

    private static final LottoDispenser instance = new LottoDispenser();
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private  LottoDispenser() {
        for (int lottoNumber = LottoNumber.MIN_LOTTO_NUMBER
                 ; lottoNumber < LottoNumber.MAX_LOTTO_NUMBER
                 ; lottoNumber++) {
            this.lottoNumbers.add(new LottoNumber(lottoNumber));
        }
    }

    public static LottoDispenser getInstance() {
        return instance;
    }

    public List<Lotto> auto(int numberOfPurchases) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfPurchases; count++) {
            lottos.add(new Lotto(getLottoNumbers()));
        }
        return lottos;
    }

    private List<LottoNumber> getLottoNumbers() {
        // 섞기
        Collections.shuffle(this.lottoNumbers);

        return new ArrayList<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }

}

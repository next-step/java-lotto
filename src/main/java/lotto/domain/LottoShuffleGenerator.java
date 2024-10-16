package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffleGenerator implements LottoGenerator {

    private static LottoShuffleGenerator lottoShuffleGenerator;

    private LottoShuffleGenerator() {

    }

    public static LottoShuffleGenerator getLottoShuffleGenerator() {
        if (lottoShuffleGenerator == null) {
            lottoShuffleGenerator = new LottoShuffleGenerator();
        }
        return lottoShuffleGenerator;
    }

    @Override
    public List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> purChasedLotto = new ArrayList<>();
        int lottoCount = calculateNumberOfLotto(purchaseAmount);
        for (int i = 0; i < lottoCount; i++) { // 이 책임을 LottoShuffleGenerator한테 넘겨보자
            purChasedLotto.add(sortLotto(shuffleLotto()));
        }
        return purChasedLotto;
    }

    List<LottoNumber> shuffleLotto() {
        Collections.shuffle(lottoGenerator);
        return new ArrayList<>(lottoGenerator.subList(FROM_INDEX, LOTTO_SIZE));
    }

    Lotto sortLotto(List<LottoNumber> shuffledLotto) {
        Collections.sort(shuffledLotto);
        return new Lotto(shuffledLotto);
    }

    public static int calculateNumberOfLotto(int purchaseAmount) {
        checkIfCanPurchaseLotto(purchaseAmount);
        return purchaseAmount / PRICE_OF_LOTTO;
    }

    private static void checkIfCanPurchaseLotto(int totalAmount) {
        if (totalAmount < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("1000원 미만으론 살 수 없음");
        }
    }

}

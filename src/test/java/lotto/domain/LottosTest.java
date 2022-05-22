package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    @Test
    void 수동으로_생성한_번호로_로또_생성() {
        final int purchaseAmount = 10000;
        final int manualLottoCount = 5;
        final int lottoPrice = 1000;
        PurchaseLottoCount purchaseLottoCount = new PurchaseLottoCount(purchaseAmount, manualLottoCount, lottoPrice);

        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            Collections.shuffle(lottoNumbers);
            List<LottoNumber> lottoNumber = LottosTest.lottoNumbers.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toList());
            lottoNumbers.add(new LottoNumbers(lottoNumber));
        }

        assertThat(new Lottos(purchaseLottoCount, lottoNumbers).getLottoNumbers()).containsAll(lottoNumbers);
    }
}

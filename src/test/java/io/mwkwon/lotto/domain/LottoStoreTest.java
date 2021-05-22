package io.mwkwon.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "25000:25", "12500:12"}, delimiter = ':')
    void 입력된_구입금액_기준_로또_구매_기능_테스트(int value, int excepted) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.buyAutoLottos(new LottoPayment(value));
        assertThat(lottoStore.getBuyLottos().size()).isEqualTo(excepted);
    }
}

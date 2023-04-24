package study.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LottoBundleTest {


    @ParameterizedTest
    @CsvSource(value = {
            "14005, 14",
            "3580, 3"
    })
    void 금액별_로또개수_테스트(int money, int trial) {
        LottoBundle lottoBundle = LottoBundle.createLottoBundle(money);
        Assertions.assertThat(lottoBundle.getLottos().size()).isEqualTo(trial);
    }
}
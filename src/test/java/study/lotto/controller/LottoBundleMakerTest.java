package study.lotto.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoBundleMakerTest {

    @ParameterizedTest
    @CsvSource(value = {
            "14005, 14",
            "3580, 3"
    })
    void 금액별_로또개수_테스트(int money, int trial) {
        List<Lotto> lottoList = LottoBundleMaker.createLottoList(money);
        assertThat(lottoList.size()).isEqualTo(trial);
    }

}
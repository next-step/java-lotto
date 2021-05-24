package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 구입 금액을 입력받으면 로또를 구매한다. (1000원당 1장)")
    @ParameterizedTest
    @CsvSource(value = {"3000,3", "14000,14", "8000,8"})
    public void buyLottoTest(int money, int count) {
        LottoBundle lottoBundle = new LottoBundle(money);
        assertThat(lottoBundle.count()).isEqualTo(count);
    }
}

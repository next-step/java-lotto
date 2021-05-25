package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 구입 금액을 입력받으면 로또를 구매한다. (1000원당 1장)")
    @ParameterizedTest
    @CsvSource(value = {"3000,3", "14000,14", "8000,8"})
    public void buyLottoTest(int money, int count) {
        LottoBundle lottoBundle = new LottoBundle(money);
        assertThat(lottoBundle.count()).isEqualTo(count);
    }

    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2000, -5000, -100})
    public void buyLottoFailedTest(int money) {
        assertThatThrownBy(() -> {
            new LottoBundle(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원 이상");
    }

    @DisplayName("로또 생성 시 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailedTest() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{-1, 2, 3, 4, 5, 46});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }
}

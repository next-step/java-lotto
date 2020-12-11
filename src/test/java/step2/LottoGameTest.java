package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void create_instance() {
        lottoGame = new LottoGame();
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액이 1000원 미만인 경우 예외 발생 테스트")
    @ValueSource(ints = {0, 300, 500, 900})
    void input_money_less_than_1000() {
        assertThatThrownBy(() -> lottoGame.buy(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.MONEY_IS_LESS_THAN_1000);
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액 만큼 로또를 구입하는지 테스트")
    @CsvSource(value = {"14000:14", "7000:7", "5000:5"}, delimiter = ':')
    void create_lottery_by_input_money(int money, int expected) {
        List<Lottery> lotteryList = lottoGame.buy(money);
        assertThat(lotteryList.size()).isEqualTo(expected);
    }
}
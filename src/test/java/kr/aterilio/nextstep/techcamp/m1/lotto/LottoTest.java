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
    public void buyLotto(int money, int count) {
        LottoBundle lottoBundle = new LottoBundle(money);
        assertThat(lottoBundle.count()).isEqualTo(count);
    }

    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2000, -5000, -100})
    public void buyLottoFailed(int money) {
        assertThatThrownBy(() -> {
            new LottoBundle(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원 이상");
    }

    @DisplayName("로또 생성 시 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailed_outOfRange() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{-1, 2, 3, 4, 5, 46});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("로또 생성 시 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailed_duplicated() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{1, 2, 3, 4, 5, 1});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("입력받는 당첨 번호는 쉼표(,)로 분리되는 숫자의 나열이며 공백은 무시한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "5, 2, 3, 1, 6, 7:6"}, delimiter = ':')
    public void createLuckyNumbers(String inputLuckyNumbers, int count) {
        LuckyNumbers luckyNumbers = new LuckyNumbers(inputLuckyNumbers);
        assertThat(luckyNumbers.count()).isEqualTo(count);
    }

    @DisplayName("입력받는 당첨 번호의 갯수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4,3,2,1", "5, 2, 3"})
    public void createLuckyNumbersFailed_count(String inputLuckyNumbers) {
        assertThatThrownBy(()-> {
            new LuckyNumbers(inputLuckyNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }
}

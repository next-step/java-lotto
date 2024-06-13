import domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LottoTest {

    private LottoGame lottoGame;

    @BeforeAll
    void beforeAll() {
        lottoGame = LottoGame.policyFrom(new GeneralLottoGamePolicy());
    }
    
    @Test
    @DisplayName("로또는 6개의 로또 번호를 가진다")
    void test1() {
        assertThat(Lotto.of(1, 2, 3, 4, 5, 6).getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또는 6개의 로또 번호를 가진다2")
    void test2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    @DisplayName("로또는 6개의 로또 번호를 가진다3")
    void test3() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("당첨 로또는 6개의 로또 번호와 1개의 보너스 로또 번호를 가진다")
    void test4() {
        assertThat(WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7))
                .getNumbers().size())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 로또는 6개의 로또 번호와 1개의 보너스 로또 번호를 가진다2")
    void test5() {
        assertThat(WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7))
                .getBonusNumber())
                .isNotNull();
    }

    @Test
    @DisplayName("로또가 가지는 로또 번호는 중복되지 않는다")
    void test6() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(1, 1, 1, 1, 1, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("당첨 로또가 가지는 로또 번호는 보너스 로또 번호와 중복되지 않는다")
    void test7(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(bonusNumber)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1부터 45까지의 정수이다")
    void test8(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(number));
    }

    @Test
    @DisplayName("6개의 로또 번호 일치시 2000000000 원을 제공한다")
    void test9() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 2, 3, 4, 5, 6),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("5개의 로또 번호와 보너스 번호 일치시 30000000 원을 제공한다")
    void test10() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 2, 3, 4, 5, 7),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(30000000);
    }

    @Test
    @DisplayName("5개의 로또 번호 일치시 1500000 원을 제공한다")
    void test11() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 2, 3, 4, 5, 8),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(1500000);
    }

    @Test
    @DisplayName("4개의 로또 번호 일치시 50000 원을 제공한다")
    void test12() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 2, 3, 4, 7, 8),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(50000);
    }

    @Test
    @DisplayName("3개의 로또 번호 일치시 5000 원을 제공한다")
    void test13() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 2, 3, 7, 8, 9),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(5000);
    }

    @Test
    @DisplayName("2개의 로또 번호 일치시 0원을 제공한다")
    void test14() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 2, 7, 8, 9, 10),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("1개의 로또 번호 일치시 0원을 제공한다")
    void test15() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(1, 7, 8, 9, 10, 11),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("0개의 로또 번호 일치시 0원을 제공한다")
    void test16() {
        LottoGamePrize lottoGamePrize = lottoGame.match(
                Lotto.of(7, 8, 9, 10, 11, 12),
                WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.from(7)));

        assertThat(lottoGamePrize.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률은 (당첨 금액/구입 금액) 으로 계산하며 소수점 둘째 자리까지 표기한다(내림으로 계산한다)")
    void test17() {

        HashMap<LottoGamePrize, Integer> lottoGameResult = new HashMap<>();
        lottoGameResult.put(LottoGamePrize.FIRST_PRIZE, 1);
        float roi = lottoGame.calculateRoi(lottoGameResult, 1);
        float actual = Float.valueOf(LottoGamePrize.FIRST_PRIZE.getValue()) / Float.valueOf(Lotto.PRICE);

        assertThat(Double.valueOf(roi * 100)).isEqualTo(Math.floor(actual * 100));
    }

}

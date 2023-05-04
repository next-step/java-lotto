package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.BonusNumber;
import step2.domain.LotteryWin;
import step2.domain.LottoFactory;
import step2.domain.PurchasedLotto;
import step2.domain.TotalNumbers;
import step2.domain.WinningNumbers;
import step2.exception.CustomNumberFormatException;

class LottoTest {

    @DisplayName("로또 번호 6자리를 출력한다.")
    @Test
    void test1() throws Exception {
        TotalNumbers totalNumbers = new TotalNumbers();

        assertThat(totalNumbers.getRandomLottoNumber()).hasSize(6);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void test4() throws Exception {
        TotalNumbers totalNumbers = new TotalNumbers();

        assertThat(totalNumbers.getRandomLottoNumber()).isSorted();
    }

    @ParameterizedTest(name = "입력 금액만큼 로또를 구매한다.")
    @ValueSource(ints = {10000, 1000, 12459})
    void test2(int input) throws Exception {
        int manualLottoCount = 0;
        PurchasedLotto lottoList = LottoFactory.of(input, manualLottoCount);

        assertThat(lottoList.get()).hasSize(input / 1000);
    }

    @ParameterizedTest(name = "입력 금액이 1000이하일 경우 예외를 던진다.")
    @ValueSource(ints = {-1, 0, 999})
    void test5(int input) throws Exception {
        int manualLottoCount = 0;
        assertThatThrownBy(() -> {
            LottoFactory.of(input, manualLottoCount);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("당첨 숫자가 숫자 포맷이 아닌 경우 예외를 던진다.")
    @Test
    void test6() throws Exception {
        String str = "1,3,5,f,8";

        assertThatExceptionOfType(CustomNumberFormatException.class)
            .isThrownBy(() -> new WinningNumbers(str))
            .withMessageMatching("For input string: \\D+");
    }

    @DisplayName("당첨 숫자가 45를 넘어가는 숫자가 포함될 경우 예외를 던진다.")
    @Test
    void test7() throws Exception {
        String str = "1,3,5,6,46";

        assertThatThrownBy(() ->
            new WinningNumbers(str)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효하지 않은 숫자입니다.");
    }

    @DisplayName("당첨 숫자가 1이하의 숫자가 포함될 경우 예외를 던진다.")
    @Test
    void test8() throws Exception {
        String str = "0,3,5,6,46";

        assertThatThrownBy(() ->
            new WinningNumbers(str)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효하지 않은 숫자입니다.");
    }

    @ParameterizedTest(name = "보너스 숫자가 유효 범위가 아닐 경우 에외를 던진다.")
    @ValueSource(ints = {0, 46, -1})
    void test9(int input) {
        assertThatThrownBy(() -> new BonusNumber(input)
        )
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효하지 않은 숫자입니다.");
    }

    @DisplayName("당첨 숫자에 보너스 번호가 있는 경우 예외를 던진다.")
    @Test
    void test10() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() ->
            new LotteryWin(winningNumbers, 1)
        )
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이미 존재하는 번호입니다.");
    }
}

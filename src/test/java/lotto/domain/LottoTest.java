package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("Lotto 를 생성 - 1~45 숫자중에 6개를 랜덤 선택한다.")
    void test01() {
        Lotto lotto = new Lotto(LottoType.MANUAL);

        assertThat(lotto.numbers()).hasSize(6);
    }

    @Test
    @DisplayName("Lotto 를 생성한다.")
    void test02() {
        Lotto lotto = new Lotto(LottoType.MANUAL, 1, 2, 3, 4, 5, 6);

        assertThat(lotto.numbers()).containsExactly(this.getNumbers(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isManualPurchasedLotto()).isTrue();
    }

    @Test
    @DisplayName("숫자 6개는 정렬이 되어있어야 한다.")
    void test03() {
        Lotto lotto = new Lotto(LottoType.AUTO, 6, 5, 4, 3, 2, 1);

        assertThat(lotto.numbers()).containsExactly(this.getNumbers(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isManualPurchasedLotto()).isFalse();
    }

    @Test
    @DisplayName("로또는 숫자 6개가 아니면 에러를 발생한다.")
    void test04() {
        assertThatThrownBy(() -> new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또의 개수가 얼마나 맞는지 카운트 확인")
    void test05() {
        Lotto lotto = new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6);

        assertThat(lotto.matchNumber(getWinNumbers(1, 2, 3, 4, 44, 45))).isEqualTo(4);
    }

    @Test
    @DisplayName("로또의 보너스 숫자가 있는지 확인한다.")
    void test06() {
        Lotto lotto = new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6);

        assertThat(lotto.matchBonusNumber(new LottoNumber(6))).isEqualTo(1);
    }

    private LottoNumber[] getNumbers(int number1, int number2, int number3, int number4, int number5, int number6) {
        return new LottoNumber[]{new LottoNumber(number1), new LottoNumber(number2), new LottoNumber(number3), new LottoNumber(number4),
                new LottoNumber(number5), new LottoNumber(number6)};
    }

    private static List<LottoNumber> getWinNumbers(int number1, int number2, int number3, int number4, int number5, int number6) {
        return List.of(new LottoNumber(number1), new LottoNumber(number2), new LottoNumber(number3),
                       new LottoNumber(number4), new LottoNumber(number5), new LottoNumber(number6));
    }
}

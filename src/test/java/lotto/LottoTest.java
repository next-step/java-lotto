package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 추첨번호는 1 ~ 45 이다.")
    @Test
    void lottoBallRange() {
        Assertions.assertThatThrownBy(() -> LottoNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> LottoNumber.from(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 랜덤 숫자를 추출한다.")
    @Test
    void getRandomNumber() {
        Lotto lotto = Lotto.lottery();
        Assertions.assertThat(lotto.getLottoNumbersCount()).isEqualTo(6);
    }

    @DisplayName("6개의 랜덤 숫자가 중복되지 않는다.")
    @Test
    void getRandomDuplicationNumber() {
        Assertions.assertThatThrownBy(() -> new Lotto(1, 1, 1, 1, 1, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 6개의 번호 구성되어야 한다.")
    @Test
    void getRandomNumber1() {
        Assertions.assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class);
    }
}

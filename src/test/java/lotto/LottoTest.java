package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {


    @Test
    @DisplayName("정답지와 로또를 비교해 일치하는 수를 반환한다.")
    void countAnswers() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        Lotto answerSheet = new Lotto(4, 5, 11, 33, 39, 44);

        assertThat(lotto.countMatchNumbers(answerSheet)).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 숫자를 갖고있으면 true를 반환한다.")
    void containsNumber() {

        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.containsNumber(LottoNumber.of(5))).isTrue();
    }


}
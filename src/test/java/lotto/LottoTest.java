package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {


    @Test
    @DisplayName("정답지와 로또를 비교해 일치하는 수를 반환한다.")
    void countAnswers() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> answerSheet = List.of(4, 5, 11, 33, 39, 48);

        assertThat(lotto.countMatchNumbers(answerSheet)).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 숫자를 갖고있으면 true를 반환한다.")
    void containsNumber(){

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.containsNumber(5)).isTrue();
    }


}
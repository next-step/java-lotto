package lotto;

import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.factory.LottoAutoFactory;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoAnswer;
import lotto.exception.LottoNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    void 로또_길이_검사() {
        LottoAutoFactory factory = new LottoAutoFactory();
        Lotto lotto = factory.newInstance();
        Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_숫자_범위_검사() {
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Assertions.assertThatThrownBy(() -> factory.newInstance("1, 2, 3, 4, 5, 99")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 로또_번호_매칭() {
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto lotto1 = factory.newInstance("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = factory.newInstance("1, 2, 3, 4, 5, 6");

        Assertions.assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);
    }

    @Test
    void 로또_숫자변환_오류() {
        Assertions.assertThatThrownBy(() -> LottoAnswer.transFormNumberList("숫자아닌값")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 로또_개수_오류() {
        Assertions.assertThatThrownBy(() -> LottoAnswer.transFormNumberList("1,2")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 로또_불변성_테스트() {
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto lotto = factory.newInstance();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertThatThrownBy(() -> numbers.add(99)).isInstanceOf(UnsupportedOperationException.class);
    }
}

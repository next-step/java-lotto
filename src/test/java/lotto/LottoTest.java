package lotto;

import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.factory.LottoAutoFactory;
import lotto.domain.lotto.Lotto;
import lotto.exception.LottoNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 99);
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Assertions.assertThatThrownBy(() -> factory.newInstance(numbers)).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 로또_번호_매칭() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto lotto1 = factory.newInstance(numbers);
        Lotto lotto2 = factory.newInstance(numbers);

        Assertions.assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);
    }
}

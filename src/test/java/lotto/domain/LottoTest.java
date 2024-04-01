package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    void create() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    void 로또_6개_아닌_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageMatching("로또 개수는 6개여야 합니다.");
    }

    @Test
    void 로또_중복_숫자_있는_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageMatching("로또에 중복 숫자가 있습니다.");
    }

    @Test
    void 보너스_번호_일치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(lotto.isContainsBonus(LottoNumber.of(7))).isTrue();
    }

    @Test
    void 일치_개수() {
        Lotto givenLotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(givenLotto.match(userLotto)).isEqualTo(3);
    }
}

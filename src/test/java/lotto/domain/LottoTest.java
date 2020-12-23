package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void valid() {
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3));
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 자동 생산된 로또 번호 비교하기")
    void drawAutomaticLotto() {
        List<LottoNumber> luckyNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)
        );
        Lotto luckyLotto = new Lotto(luckyNumbers);
        Lotto lotto = new Lotto(numbers);
        lotto.draw(luckyLotto);
        assertThat(lotto.getMatchingCount()).isEqualTo(3);
    }

}

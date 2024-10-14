package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    void shuffle() {
        LottoNumbers defaultNumbers = new LottoNumbers();
        LottoNumbers shuffledNumbers = new LottoNumbers();

        shuffledNumbers.shuffle();

        assertThat(defaultNumbers.getNumbers()).isNotEqualTo(shuffledNumbers.getNumbers());
    }

    @Test
    @DisplayName("로또볼 변경 불가능 테스트")
    void getBalls() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        assertThatThrownBy(() -> lottoNumbers.getNumbers().set(0, new LottoNo(10)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.getNumbers().add(new LottoNo(50)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.getNumbers().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validate_로또번호범위_이내() {
        Set<LottoNo> numbers = Set.of(new LottoNo(1), new LottoNo(10), new LottoNo(21)
                , new LottoNo(31), new LottoNo(41), new LottoNo(45));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate_로또번호범위_이외() {
        Set<LottoNo> numbers = Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3)
                , new LottoNo(4), new LottoNo(5), new LottoNo(46));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }
}

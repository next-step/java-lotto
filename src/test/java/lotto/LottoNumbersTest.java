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
        LottoNumbers defaultNumbers = LottoNumbers.of();
        LottoNumbers shuffledNumbers = LottoNumbers.of();

        shuffledNumbers.shuffle();

        assertThat(defaultNumbers.getNumbers()).isNotEqualTo(shuffledNumbers.getNumbers());
    }

    @Test
    @DisplayName("로또볼 변경 불가능 테스트")
    void getBalls() {
        LottoNumbers lottoNumbers = LottoNumbers.of();

        assertThatThrownBy(() -> lottoNumbers.getNumbers().set(0, LottoNo.of(10)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.getNumbers().add(LottoNo.of(45)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.getNumbers().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validate_로또번호범위_이내() {
        Set<LottoNo> numbers = Set.of(LottoNo.of(1), LottoNo.of(10), LottoNo.of(21)
                , LottoNo.of(31), LottoNo.of(41), LottoNo.of(45));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

}

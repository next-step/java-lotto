package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 1장당 [1-45] 사이 6개 숫자가 랜덤으로 발급 된다.")
    void testCreateLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getNumbers()).hasSize(6);

        lottoNumbers = new LottoNumbers(new LottoRandomGenerator(1L));
        assertThat(lottoNumbers.getNumbers().stream().sorted()).hasSize(6)
                .containsExactly(
                        new LottoNumber(5),
                        new LottoNumber(16),
                        new LottoNumber(29),
                        new LottoNumber(34),
                        new LottoNumber(38),
                        new LottoNumber(45));

        lottoNumbers = new LottoNumbers(new LottoRandomGenerator(2L));
        assertThat(lottoNumbers.getNumbers().stream().sorted()).hasSize(6).containsExactly(
                new LottoNumber(14),
                new LottoNumber(16),
                new LottoNumber(21),
                new LottoNumber(25),
                new LottoNumber(38),
                new LottoNumber(43)
        );
    }

    @Test
    @DisplayName("지난 주 당첨 번호를 입력 받는다.")
    void testLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers("14, 16, 21, 25, 38, 40");
        assertThat(lottoNumbers.getNumbers()).contains(
                new LottoNumber(14),
                new LottoNumber(16),
                new LottoNumber(21),
                new LottoNumber(25),
                new LottoNumber(38),
                new LottoNumber(40)
        );
    }

    @Test
    @DisplayName("로또 번호는 숫자 6개가 아니면 예외를 발생 시킨다.")
    void testLottoNumbersConstraint() {
        assertThatThrownBy(() -> {
            new LottoNumbers("100");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNumbers("1, 2, 16, 21, 25");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNumbers("1, 2, 16, 21, 25, 38, 40");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNumbers((Set.of(new LottoNumber(1))));
        }).isInstanceOf(IllegalArgumentException.class);

    }
}

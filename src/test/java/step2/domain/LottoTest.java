package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.constants.Constants;
import step2.generator.NumberGenerator;
import step2.generator.TestLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    private NumberGenerator numberGenerator = new TestLottoNumberGenerator();

    @Test
    @DisplayName("번호가 6개인 로또가 생성된다")
    void from() {
        Lotto lotto = Lotto.from(numberGenerator);
        assertThat(lotto.getNumbers().size()).isEqualTo(Constants.LOTTO_SIZE);
    }

    @Test
    @DisplayName("생성된 로또번호는 오름차순으로 정렬되어있다")
    void sort() {
        Lotto lotto = Lotto.from(numberGenerator);
        assertAll(
            () -> assertThat(lotto.getNumbers().get(0)).isEqualTo(Number.from(1)),
            () -> assertThat(lotto.getNumbers().get(1)).isEqualTo(Number.from(2)),
            () -> assertThat(lotto.getNumbers().get(2)).isEqualTo(Number.from(3)),
            () -> assertThat(lotto.getNumbers().get(3)).isEqualTo(Number.from(4)),
            () -> assertThat(lotto.getNumbers().get(4)).isEqualTo(Number.from(5)),
            () -> assertThat(lotto.getNumbers().get(5)).isEqualTo(Number.from(6))
        );
    }
}

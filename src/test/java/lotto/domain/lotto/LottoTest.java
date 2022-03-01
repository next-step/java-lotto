package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(new Numbers("1,2,3,4,5,6"));
    }

    @DisplayName("Lotto에 Number가 있다면, 참을 반환한다.")
    @Test
    void givenNumber_whenNumberInLotto_thenTrue() {
        final Number number = new Number(1);
        assertThat(lotto.hasNumber(number)).isTrue();
    }

    @DisplayName("Lotto에 Number가 없다면, 거짓을 반환한다.")
    @Test
    void givenNumber_whenNotNumberInLotto_thenFalse() {
        final Number number = new Number(7);
        assertThat(lotto.hasNumber(number)).isFalse();
    }

    @DisplayName("두 Lotto 내부에서 같은 Number의 개수를 반환한다. ")
    @Test
    void givenOtherLotto_whencompareTwoLottos_thenMatchCount() {
        final Lotto otherLotto = new Lotto(new Numbers("1,2,3,4,6,7"));

        assertThat(lotto.getMatchCount(otherLotto)).isEqualTo(5);
    }
}
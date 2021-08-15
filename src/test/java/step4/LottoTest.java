package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoTest {

    @DisplayName("로또 생성 기능")
    @Test
    void create() {
        // Given && When
        List<LottoNumber> givenLottoNumber = LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = Lotto.create(givenLottoNumber);

        // Then
        assertThat(lotto.numbers()).isEqualTo(givenLottoNumber);
    }

    @DisplayName("같은 로또 번호가 있다면 IllegalArgumentException 발생")
    @Test
    void occurIllegalArgumentExceptionWhenCreateDuplication() {
        // Given && When
        List<LottoNumber> givenLottoNumber = LottoNumbersFactory.buildLottoNumbers(1, 1, 1, 1, 1, 1);

        // When && Then
        assertThrows(IllegalArgumentException.class, () -> Lotto.create(givenLottoNumber));
    }

    @DisplayName("로또 숫자가 6개가 아니면 IllegalArgumentException 발생")
    @Test
    void occurIllegalArgumentExceptionWhenCreateWrongSize() {
        // Given && When
        List<LottoNumber> givenLottoNumber = LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 7, 6);

        // When && Then
        assertThrows(IllegalArgumentException.class, () -> Lotto.create(givenLottoNumber));
    }


}

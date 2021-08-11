package step4;

import org.junit.jupiter.api.Test;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoTest {

    @Test
    void 로또_생성_기능() {
        // Given && When
        List<LottoNumber> givenLottoNumber = LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = Lotto.create(givenLottoNumber);

        // Then
        assertThat(lotto.numbers()).isEqualTo(givenLottoNumber);
    }

    @Test
    void 같은_로또_번호가_있다면_IllegalArgumentException_발생() {
        // Given && When
        List<LottoNumber> givenLottoNumber = LottoNumbersFactory.buildLottoNumbers(1, 1, 1, 1, 1, 1);

        // When && Then
        assertThrows(IllegalArgumentException.class, () -> Lotto.create(givenLottoNumber));
    }

    @Test
    void 로또_숫자가_6개가_아니면_IllegalArgumentException_발생() {
        // Given && When
        List<LottoNumber> givenLottoNumber = LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 7, 6);

        // When && Then
        assertThrows(IllegalArgumentException.class, () -> Lotto.create(givenLottoNumber));
    }


}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(ints = {6, 0, 46})
    public void 잘못된_보너스번호_입력시_예외를_발생한다(int bonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber));
    }

    @CsvSource(value = {"7,SECOND", "8,THIRD"}, delimiter = ',')
    @ParameterizedTest
    public void 로또보너스_번호가_존재확인(int bonusNumber, LottoRank rank) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 9), bonusNumber);

        assertThat(winningLotto.match(lotto)).isEqualTo(rank);
    }

}

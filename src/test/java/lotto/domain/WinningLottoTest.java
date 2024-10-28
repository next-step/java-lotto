package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningLottoTest {
    @CsvSource(value = {"7,true", "8,false"}, delimiter = ',')
    @ParameterizedTest
    public void 로또보너스_번호가_존재확인(int bonusNumber, boolean result) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(33, 34, 35, 36, 37, 38), bonusNumber);

        assertThat(winningLotto.hasBonusNumber(lotto)).isEqualTo(result);
    }

}

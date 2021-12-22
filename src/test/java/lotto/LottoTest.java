package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("Lotto 객체를 생성한다")
    void shouldCreateSameObject() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 일치하는 개수를 구한다")
    void shouldSetMatchedLottoNumbersCount() {
        LottoNumbers input = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.from(input);
        LottoNumbers winningNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 7, 8, 9));

        long matchedLottoNumbersCount = lotto.match(winningNumbers);
        assertThat(matchedLottoNumbersCount).isEqualTo(3L);
    }

    @Test
    @DisplayName("보너스 번호와 일치하면 true를 반환한다")
    void shouldMatchBonusNumber() {
        LottoNumbers input = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.from(input);
        LottoNumber bonusNumber = LottoNumber.from("1");

        boolean result = lotto.isMatchedBonusNumber(bonusNumber);
        assertThat(result).isTrue();
    }
}

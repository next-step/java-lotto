package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerNumbersTest {
    private WinnerNumbers winnerNumbers = new WinnerNumbers(
            Set.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ),
            new BonusNumber(7)
    );

    private LottoNumbers lottoNumbers1 = new LottoNumbers(
            Set.of(
                    new LottoNumber(11),
                    new LottoNumber(12),
                    new LottoNumber(13),
                    new LottoNumber(14),
                    new LottoNumber(15),
                    new LottoNumber(16)
            )
    );

    private LottoNumbers lottoNumbers2 = new LottoNumbers(
            Set.of(
                    new LottoNumber(11),
                    new LottoNumber(12),
                    new LottoNumber(13),
                    new LottoNumber(14),
                    new LottoNumber(15),
                    new LottoNumber(7)
            )
    );
    @Test
    public void contains() {
        assertThat(winnerNumbers.isMatchBonus(lottoNumbers1)).isFalse();
        assertThat(winnerNumbers.isMatchBonus(lottoNumbers2)).isTrue();
    }
}

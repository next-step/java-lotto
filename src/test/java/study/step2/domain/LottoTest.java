package study.step2.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step2.domain.dto.WinningNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 당첨_계산() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3, 5, 6, 9, 23, 43));
        lotto.match(winningNumbers);
        assertThat(lotto.hitCount()).isEqualTo(3);
    }
}

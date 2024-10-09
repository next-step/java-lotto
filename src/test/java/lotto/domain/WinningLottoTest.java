package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 당첨번호_확인() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::generateByValue)
                .collect(Collectors.toList());

        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 13, 15, 16)
                .map(LottoNumber::generateByValue)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        assertThat(winningLotto.calculateWinningCount(lotto)).isEqualTo(3);
    }
}

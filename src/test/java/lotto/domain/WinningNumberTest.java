package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    void 당첨번호_생성() {
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        WinningNumber winningNumber = new WinningNumber(lottoNumbers);
        assertThat(winningNumber).isNotNull();
    }

    @Test
    void 당첨번호_중복검증() {
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new WinningNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_개수검증() {
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new WinningNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일등_당첨() {
        Set<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        assertThat(winningNumber.findLottoRewards(lotto)).isEqualTo(LottoRewards.FIRST);
    }
}
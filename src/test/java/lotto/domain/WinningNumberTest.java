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
        Set<Integer> lottoNumbers = getLottoNumbers();
        WinningNumber winningNumber = new WinningNumber(lottoNumbers, 7);
        assertThat(winningNumber).isNotNull();
    }

    @Test
    void 당첨번호_중복검증() {
        Set<Integer> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 5)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_개수검증() {
        Set<Integer> lottoNumbers = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일등_당첨() {
        Set<Integer> winningNumbers = getLottoNumbers();
        Set<Integer> lottoNumbers = getLottoNumbers();
        Lotto lotto = Lotto.from(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, 7);

        assertThat(winningNumber.findLottoRewards(lotto)).isEqualTo(LottoRewards.FIRST);
    }

    @Test
    void 보너스번호_포함_당천번호_생성() {
        Set<Integer> winningNumbers = getLottoNumbers();
        WinningNumber winningNumber = new WinningNumber(winningNumbers, 7);
        assertThat(winningNumber).isNotNull();
    }

    @Test
    void 보너스번호_당천번호_중복_검증() {
        Set<Integer> winningNumbers = getLottoNumbers();
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Set<Integer> getLottoNumbers() {
        return Set.of(1, 2, 3, 4, 5, 6);
    }
}
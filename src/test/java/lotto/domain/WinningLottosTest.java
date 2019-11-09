package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottosTest {

    @Test
    void 당첨로또_추가() {
        final List<LottoNumber> numbers = Arrays.asList(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        );
        Lotto lotto = new Lotto(numbers);

        WinningLottos winningLottos = new WinningLottos();
        winningLottos.addOnlyWinning(lotto, Rank.FIRST);
        assertThat(winningLottos.getCountOf(Rank.FIRST)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = 10_000)
    void 수익률_계산(final int money) {
        final List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        Lotto lotto = new Lotto(numbers);

        WinningLottos winningLottos = new WinningLottos();
        winningLottos.addOnlyWinning(lotto, Rank.FIFTH);
        double rate = winningLottos.getRate(money);
        assertThat(rate).isEqualTo(0.50);
    }
}

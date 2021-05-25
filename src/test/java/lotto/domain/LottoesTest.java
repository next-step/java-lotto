package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoesTest {

    @DisplayName("수동 로또를 구입하면 로또 개수가 1개 증가한다")
    @Test
    void buy_manual_lotto() {
        // given
        Lottoes lottoes = Lottoes.init();

        // when
        lottoes.buyManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lottoes.getLottoCount()).isEqualTo(1);
    }

    @DisplayName("자동 로또를 구입하면 로또 개수가 1개 증가한다")
    @Test
    void buy_auto_lotto() {
        // given
        Lottoes lottoes = Lottoes.init();

        // when
        lottoes.buyAutoLotto(new TestLottoNumberGenerator());

        // then
        assertThat(lottoes.getLottoCount()).isEqualTo(1);
    }

    @DisplayName("당첨번호를 입력하면 Rank별로 당첨 개수를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:3:false:7", "1,2,3,4,10,11:4:false:7", "1,2,3,4,5,10:5:false:7",
            "1,2,3,4,5,10:5:true:6", "1,2,3,4,5,6:6:false:7"}, delimiter = ':')
    void getRankCount(String winningLottoNumbers, int matchCount, boolean matchBonus, int bonusNumber) {
        // given
        Lottoes lottoes = Lottoes.init();
        lottoes.buyAutoLotto(new TestLottoNumberGenerator());

        Rank rank = Rank.valueOf(matchCount, matchBonus);
        Lotto enteredWinningLotto = Lotto.from(Arrays.asList(winningLottoNumbers.split(","))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(toList()));
        LottoNumber lottoBonusNumber = LottoNumber.from(bonusNumber);
        WinningLotto winningLotto = WinningLotto.of(enteredWinningLotto, lottoBonusNumber);

        // when
        int rankCount = lottoes.getRankCount(winningLotto, rank);

        // then
        assertThat(rankCount).isEqualTo(1);
    }
}

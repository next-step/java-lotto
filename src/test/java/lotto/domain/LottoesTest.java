package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoesTest {

    @DisplayName("로또를 구입하면 로또 개수가 1개 증가한다")
    @Test
    void buy_lotto() {
        // given
        Lottoes lottoes = Lottoes.init();

        // when
        lottoes.buyLotto(new TestLottoNumberGenerator());

        // then
        assertThat(lottoes.getLottoCount()).isEqualTo(1);
    }

    @DisplayName("당첨번호를 입력하면 Rank별로 당첨 개수를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:3", "1,2,3,4,10,11:4", "1,2,3,4,5,7:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    void getRankCount(String winnerLottoNumbers, int matchCount) {
        // given
        Lottoes lottoes = Lottoes.init();
        lottoes.buyLotto(new TestLottoNumberGenerator());
        Rank rank = Rank.valueOf(matchCount);
        Lotto winnerLotto = Lotto.from(Arrays.asList(winnerLottoNumbers.split(","))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(toList()));

        // when
        int rankCount = lottoes.getRankCount(winnerLotto, rank);

        // then
        assertThat(rankCount).isEqualTo(1);
    }
}

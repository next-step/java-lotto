package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningResultsTest {
    @Test
    @DisplayName("당첨로또 확인 : 3개 수 당첨 2개")
    void two_win_lotto_test() {
        LottoWinningResults winningResults = new LottoWinningResults();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Stream.of(1,2,4,6,9,10).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7,11,14,15,35,38).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(2,7,10,13,34,41).map(LottoNumber::new).collect(Collectors.toList()))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers);
        assertThat(results).containsEntry(WinType.THREE_MATCH, 2);
    }

    @Test
    @DisplayName("당첨로또 확인 : 당첨 안된 로또 2개")
    void zero_win_lotto_test() {
        LottoWinningResults winningResults = new LottoWinningResults();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Stream.of(3,4,22,36,39,45).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7,11,14,15,35,38).map(LottoNumber::new).collect(Collectors.toList()))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers);
        assertThat(results).containsEntry(WinType.NO_MATCH, 2);
    }
}

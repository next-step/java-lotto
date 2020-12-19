package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCheckerTest {
    @Test
    @DisplayName("당첨로또 확인 : 당첨 안된 로또")
    void no_match_test() {
        WinningChecker winningResults = new WinningChecker();
        List<Lotto> lottolist = Arrays.asList(
                new Lotto(Stream.of(3, 4, 22, 36, 39, 45).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 38).map(LottoNumber::new).collect(Collectors.toList()))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        String bonumsNumber = "3";
        Lottos lottos = new Lottos(lottolist);
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers, new LottoNumber(bonumsNumber));
        assertThat(results).containsEntry(WinType.NO_MATCH, 2);
    }

    @Test
    @DisplayName("당첨로또 확인 : 3자리 맞춤")
    void three_match_test() {
        WinningChecker checker = new WinningChecker();
        List<Lotto> lottolist = Arrays.asList(
                new Lotto(Stream.of(1, 2, 5, 6, 9, 10).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(2, 7, 10, 13, 34, 41).map(LottoNumber::new).collect(Collectors.toList()))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        String bonumsNumber = "3";
        Lottos lottos = new Lottos(lottolist);
        Map<WinType, Integer> results = checker.checkWinLotto(lottos, winNumbers, new LottoNumber(bonumsNumber));
        assertThat(results).containsEntry(WinType.THREE_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 4자리 맞춤")
    void four_match_test() {
        WinningChecker winningResults = new WinningChecker();
        List<Lotto> lottolist = Arrays.asList(
                new Lotto(Stream.of(3, 4, 5, 10, 34, 43).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 38).map(LottoNumber::new).collect(Collectors.toList()))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        String bonumsNumber = "3";
        Lottos lottos = new Lottos(lottolist);
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers, new LottoNumber(bonumsNumber));
        assertThat(results).containsEntry(WinType.FOUR_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 5자리 맞춤")
    void five_match_test() {
        WinningChecker winningResults = new WinningChecker();
        List<Lotto> lottolist = Arrays.asList(
                new Lotto(Stream.of(1, 2, 5, 10, 34, 9).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 38).map(LottoNumber::new).collect(Collectors.toList()))
        );

        Lottos lottos = new Lottos(lottolist);
        String winNumbers = "1, 2, 5, 10, 34, 43";
        String bonumsNumber = "3";
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers, new LottoNumber(bonumsNumber));
        assertThat(results).containsEntry(WinType.FIVE_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 5자리 + 보너스 수 맞춤")
    void bonus_match_test() {
        WinningChecker winningResults = new WinningChecker();
        List<Lotto> lottolist = Arrays.asList(
                new Lotto(Stream.of(1, 2, 5, 10, 34, 3).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 38).map(LottoNumber::new).collect(Collectors.toList()))
        );

        Lottos lottos = new Lottos(lottolist);
        String winNumbers = "1, 2, 5, 10, 34, 43";
        String bonumsNumber = "3";
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers, new LottoNumber(bonumsNumber));
        assertThat(results).containsEntry(WinType.BONUMS_MATCH, 1);
    }

    @Test
    @DisplayName("당첨로또 확인 : 6자리 맞춤")
    void six_match_test() {
        WinningChecker winningResults = new WinningChecker();
        List<Lotto> lottolist = Arrays.asList(
                new Lotto(Stream.of(1, 2, 4, 6, 9, 10).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 38).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 2).map(LottoNumber::new).collect(Collectors.toList()))
        );
        Lottos lottos = new Lottos(lottolist);
        String winNumbers = "7, 11, 14, 15, 35, 2";
        String bonumsNumber = "38";
        Map<WinType, Integer> results = winningResults.checkWinLotto(lottos, winNumbers, new LottoNumber(bonumsNumber));
        assertThat(results).containsEntry(WinType.SIX_MATCH, 1);
    }

}

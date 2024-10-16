package lotto.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoWinningScannerTest {

    @Test
    void 전체_검증_계산() {

        LottoWinningScanner lottoWinningScanner = new LottoWinningScanner();

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Winning winning = new Winning(winningNumbers, 7);

        LottoResult result = lottoWinningScanner.result(lottos, winning, 1000);

        Map<Rank, Integer> collect = result.getWinningResults().stream().collect(Collectors.toMap(WinningResult::getRank, WinningResult::getCount));

        assertAll(
                () -> assertThat(collect.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(result.getRate()).isEqualTo(new BigDecimal("2000000.00"))
        );

    }
}

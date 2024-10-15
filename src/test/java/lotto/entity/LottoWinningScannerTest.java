package lotto.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
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
        LottoResult result = lottoWinningScanner.result(lottos, winningNumbers, 1000);

        Map<PrizeMoney, Integer> collect = result.getWinningResults().stream().collect(Collectors.toMap(WinningResult::getPrizeMoney, WinningResult::getCount));

        assertAll(
                () -> assertThat(collect.get(PrizeMoney.SIX)).isEqualTo(1),
                () -> assertThat(result.getRate()).isEqualTo(new BigDecimal("2000000.00"))
        );

    }
}

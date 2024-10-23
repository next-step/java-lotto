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

        List<Lotto> lottos = Arrays.asList(
                Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(number -> new LottoNumber(number)).collect(Collectors.toList()))
        );

        Set<LottoNumber> winningNumbers = Set.of(1, 2, 3, 4, 5, 6).stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet());
        Winning winning = new Winning(winningNumbers, new LottoNumber(7));

        LottoResult result = LottoWinningScanner.result(lottos, winning, 1000);

        Map<Rank, Integer> collect = result.getWinningResults().stream().collect(Collectors.toMap(WinningResult::getRank, WinningResult::getCount));

        assertAll(
                () -> assertThat(collect.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(result.getRate()).isEqualTo(new BigDecimal("2000000.00"))
        );

    }
}

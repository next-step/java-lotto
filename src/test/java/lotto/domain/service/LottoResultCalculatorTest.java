package lotto.domain.service;

import lotto.domain.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {
    @DisplayName("로또 결과를 계산한다.")
    @Test
    void evaluateLottostest() {
        List<LottoNumber> winNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        LottoNumber bonusNumber = new LottoNumber(7);
        WinningTicket winningTicket = new WinningTicket(winNumbers, bonusNumber);

        List<LottoTicket> lottos = List.of(
                new LottoTicket(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new LottoTicket(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(7)
                )),
                new LottoTicket(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9),
                        new LottoNumber(10)
                ))
        );

        MatchResult matchResult = LottoResultCalculator.evaluateLottos(winningTicket, lottos);

        assertThat(matchResult.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(matchResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(matchResult.getCount(Rank.THIRD)).isEqualTo(0);
        assertThat(matchResult.getCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(matchResult.getCount(Rank.FIFTH)).isEqualTo(0);
        assertThat(matchResult.getCount(Rank.MISS)).isEqualTo(1);
    }
}

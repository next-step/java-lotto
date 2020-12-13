package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<LottoNumber> lottoNumbers1 = new ArrayList<>();
        Arrays.asList(1, 8, 10, 14, 21, 30)
                .forEach(num -> lottoNumbers1.add(new LottoNumber(num)));
        lottoTickets.add(new LottoTicket(lottoNumbers1));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        Arrays.asList(2, 8, 10, 20, 21, 45)
                .forEach(num -> lottoNumbers2.add(new LottoNumber(num)));
        lottoTickets.add(new LottoTicket(lottoNumbers2));

        lottoGame = new LottoGame(new LottoTickets(lottoTickets));
    }

    @DisplayName("발급한 로또 티켓들과 당첨 번호를 비교하여 각 맞춘 갯수들을 저장하여 리턴한다.")
    @Test
    void matchNumbers() {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        Arrays.asList(1, 8, 10, 14, 21, 40)
                .forEach(num -> winningNumbers.add(new LottoNumber(num)));

        Map<MatchPrize, Integer> results = lottoGame.matchNumbers(winningNumbers);
        assertThat(results.get(MatchPrize.THREE)).isEqualTo(1);
        assertThat(results.get(MatchPrize.FOUR)).isZero();
        assertThat(results.get(MatchPrize.FIVE)).isEqualTo(1);
        assertThat(results.get(MatchPrize.SIX)).isZero();
    }
}

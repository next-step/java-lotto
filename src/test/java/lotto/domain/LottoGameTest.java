package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;
import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        WinningLottoNumbers wLN = new WinningLottoNumbers(new LottoTicket(provideWinningNumbers()), new LottoNumber(30));
        Map<Rank, Integer> results = lottoGame.matchNumbers(wLN);

        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isZero();
        assertThat(results.get(Rank.THIRD)).isZero();
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.FIRST)).isZero();
    }

    private List<LottoNumber> provideWinningNumbers() {
        return Stream.of(1, 8, 10, 14, 21, 40)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

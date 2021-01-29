package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersLottoMatcherTest {

    private LottoMatcher lottoMatcher;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();
    }

    @DisplayName(value = "로또 티켓의 번호를 입력하면 일치 번호 개수를 출력한다.")
    @Test
    void getLottoTicketCount() {
        List<LottoNumber> lottoNumber = new ArrayList<>();
        lottoNumber.add(new LottoNumber(1));
        lottoNumber.add(new LottoNumber(3));
        lottoNumber.add(new LottoNumber(5));
        lottoNumber.add(new LottoNumber(14));
        lottoNumber.add(new LottoNumber(22));
        lottoNumber.add(new LottoNumber(45));

        List<LottoNumber> winnerNumbers = new ArrayList<>();
        winnerNumbers.add(new LottoNumber(1));
        winnerNumbers.add(new LottoNumber(2));
        winnerNumbers.add(new LottoNumber(3));
        winnerNumbers.add(new LottoNumber(4));
        winnerNumbers.add(new LottoNumber(5));
        winnerNumbers.add(new LottoNumber(6));

        WinnerLotto winnerLotto = new WinnerLotto(new LottoNumber(7), winnerNumbers);
        assertThat(lottoMatcher.getMatchCnt(lottoNumber, winnerLotto)).isEqualTo(3);
    }

}
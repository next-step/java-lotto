package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    private LottoMatcher lottoMatcher;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();
    }

    @DisplayName(value = "로또 티켓의 번호를 입력하면 일치 번호 개수를 출력한다.")
    @Test
    void getLottoTicketCount() {
        List<Integer> lottoNumber = new ArrayList<>(Arrays.asList(1, 3, 5, 14, 22, 45));
        List<Integer> winnerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoMatcher.getMatchCnt(lottoNumber, winnerNumbers)).isEqualTo(3);
    }

}
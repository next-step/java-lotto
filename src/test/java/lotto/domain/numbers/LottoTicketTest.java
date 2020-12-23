package lotto.domain.numbers;

import lotto.domain.LottoNumberConverter;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 30)));
    }

    @DisplayName("LottoTicket 생성 시 로또 숫자가 6개 아닌 경우, Exception 발생")
    @Test
    void validateSize() {
        assertThatThrownBy(() -> new LottoTicket(LottoNumberConverter.of(Arrays.asList(2, 3, 4))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개만 가능합니다.");
    }

    @DisplayName("중복된 로또 번호가 있을 경우, Exception 발생")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 8, 20, 26, 40))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 로또 번호가 있습니다.");
    }

    @DisplayName("당첨 번호와 모두 일치할 경우 Rank.FIRST를 리턴한다.")
    @Test
    void matchWinningLotto_1등() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 30)));

        Rank result = lottoTicket.matchWinningLotto(new WinningLottoTicket(winningTicket, LottoNumber.of(45)));

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨 번호와 5개 일치 & 보너스볼과 일치할 경우 Rank.SECOND를 리턴한다.")
    @Test
    void matchWinningLotto_2등() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 31)));

        Rank result = lottoTicket.matchWinningLotto(new WinningLottoTicket(winningTicket, LottoNumber.of(30)));

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @DisplayName("당첨 번호와 5개 일치 & 보너스볼과 일치하지 않을 경우 Rank.THIRD를 리턴한다.")
    @Test
    void matchWinningLotto_3등() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 31)));

        Rank result = lottoTicket.matchWinningLotto(new WinningLottoTicket(winningTicket, LottoNumber.of(23)));

        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨 번호와 4개 일치할 경우 Rank.FOURTH를 리턴한다.")
    @Test
    void matchWinningLotto_4등() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 22, 31)));

        Rank result = lottoTicket.matchWinningLotto(new WinningLottoTicket(winningTicket, LottoNumber.of(45)));

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨 번호와 3개 일치할 경우 Rank.FIFTH를 리턴한다.")
    @Test
    void matchWinningLotto_5등() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 15, 22, 31)));

        Rank result = lottoTicket.matchWinningLotto(new WinningLottoTicket(winningTicket, LottoNumber.of(45)));

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨 번호와 3개 아래로 일치할 경우 Rank.MISS를 리턴한다.")
    @Test
    void matchWinningLotto_꽝() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 11, 15, 22, 31)));

        Rank result = lottoTicket.matchWinningLotto(new WinningLottoTicket(winningTicket, LottoNumber.of(45)));

        assertThat(result).isEqualTo(Rank.MISS);
    }
}

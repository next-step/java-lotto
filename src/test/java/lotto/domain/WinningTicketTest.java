package lotto.domain;

import lotto.exception.InvalidBonusNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
    }

    @Test
    @DisplayName("보너스 숫자가 당첨번호와 중복되면 InvalidBonusNumberException 발생")
    void throwInvalidBonusExceptionTest() {
        LottoNumber bonusNumber = lottoTicket.getLottoNumbers()
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);

        assertThatThrownBy(() -> new WinningTicket(lottoTicket, bonusNumber))
                .isInstanceOf(InvalidBonusNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    @DisplayName("입력된 보너스 숫자와 당첨 티켓의 보너스 숫자가 같으면 true 반환")
    void isMatchBonusNumberTrueTest(int bonusNumber) {
        WinningTicket winningTicket = new WinningTicket(lottoTicket, new LottoNumber(bonusNumber));
        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(bonusNumber))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"10:11", "20:30", "30:15"}, delimiter = ':')
    @DisplayName("입력된 보너스 숫자와 당첨 티켓의 보너스 숫자가 다르면 false 반환")
    void isMatchBonusNumberFalseTest(int bonusNumber, int inputBonusNumber) {
        WinningTicket winningTicket = new WinningTicket(lottoTicket, new LottoNumber(bonusNumber));
        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(inputBonusNumber))).isFalse();
    }

    @Test
    @DisplayName("로또 티켓과 비교하여 rank 반환")
    void gerRankTest() {
        WinningTicket winningTicket = new WinningTicket(lottoTicket, new LottoNumber(10));
        Rank rank_1 = winningTicket.getRank(new LottoTicket(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )));
        Rank rank_2 = winningTicket.getRank(new LottoTicket(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(10)
        )));
        Rank rank_3 = winningTicket.getRank(new LottoTicket(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(15)
        )));
        Rank rank_4 = winningTicket.getRank(new LottoTicket(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(25),
                new LottoNumber(27)
        )));
        Rank rank_5 = winningTicket.getRank(new LottoTicket(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(41),
                new LottoNumber(25),
                new LottoNumber(27)
        )));
        Rank rank_6 = winningTicket.getRank(new LottoTicket(Set.of(
                new LottoNumber(11),
                new LottoNumber(21),
                new LottoNumber(31),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        )));
        assertThat(rank_1).isEqualTo(Rank.FIRST);
        assertThat(rank_2).isEqualTo(Rank.SECOND);
        assertThat(rank_3).isEqualTo(Rank.THIRD);
        assertThat(rank_4).isEqualTo(Rank.FOURTH);
        assertThat(rank_5).isEqualTo(Rank.FIFTH);
        assertThat(rank_6).isEqualTo(Rank.LOSE);
    }

    @Test
    @DisplayName("생성된 당첨 티켓과 보너스 넘버가 같을 경우 true 반환")
    void returnTrueWhenGeneratedWinningTicketHasSameBonusNumber() {
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        WinningTicket winningTicket = new WinningTicket(lottoNumbers, new LottoNumber(7));

        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(7))).isTrue();
    }
}
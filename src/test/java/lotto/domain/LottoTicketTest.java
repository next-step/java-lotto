package lotto.domain;

import lotto.utils.LottoValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

    private LottoTicket lottoTicket;
    private LottoTicket winningNumber;
    private BonusNumber bonusNumber;
    private WinningNumber winningNumbers;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,7));
        winningNumber = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        bonusNumber = new BonusNumber(7);
        winningNumbers = new WinningNumber(winningNumber, bonusNumber);
    }

    @Test
    @DisplayName("로또 티켓의 번호가 1 ~ 45가 아니라면 Exception 발생")
    void validateLottoNumberRange() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.validateLottoNumberRange(Arrays.asList(-1, 45, 50, 100, 99));
                });
    }

    @Test
    @DisplayName("로또 티켓의 숫자 개수가 6개가 아니라면 Exception 발생")
    void validateLottoTicketSize() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.validateLottoNumberSizeToSix(Arrays.asList(1, 2, 3, 4, 5));
                });
    }

    @Test
    @DisplayName("로또 티켓의 숫자가 중복이 있을 경우 Exception 발생")
    void validateLottoTicketNumberDuplicate() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.validateNumberDuplication(Arrays.asList(1, 1, 3, 4, 5, 6));
                });
    }

    @Test
    @DisplayName("로또 복권 숫자에 보너스 번호가 포함되어있는지 확인")
    void isContainsBonusNumber() {
        assertThat(lottoTicket.isContainsBonusNumber(winningNumbers)).isTrue();
    }

    @Test
    @DisplayName("로또 복권 숫자에서 맞는 당첨번호의 개수 확인")
    void getLottoTicketMatchCount() {
        assertThat(lottoTicket.getMatchCount(winningNumbers)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 복권 결과가 몇등인지 확인")
    void matchRank() {
        assertThat(lottoTicket.matchRank(winningNumbers)).isEqualTo(Rank.SECOND);
    }

}

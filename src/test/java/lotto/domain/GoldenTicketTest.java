package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GoldenTicketTest {

    private GoldenTicket goldenTicket;

    @BeforeEach
    void setUp() {
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(45);
        goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
    }

    @DisplayName("당첨 번호와 로또 티켓을 대조하여 보너스 볼 포함 여부 확인")
    @Test
    void containsBonusBallTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());

        // when
        boolean isContainBonusBall = goldenTicket.containsBonusBall(lottoTicket);

        // then
        assertThat(isContainBonusBall).isTrue();
    }

    @DisplayName("당첨 번호와 로또 티켓을 대조하여 동일한 번호의 개수 확인")
    @Test
    void getMatchedNumbersCountTest() {
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());

        // when
        int matchedNumbersCount = goldenTicket.getMatchedNumbersCount(lottoTicket);

        // then
        assertThat(matchedNumbersCount).isEqualTo(5);
    }

    private List<LottoNumber> createPickedWinningNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(43)
        );
    }

    private List<LottoNumber> createPickedSecondNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(45)
        );
    }
}
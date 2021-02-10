package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GoldenTicketTest {

    @DisplayName("당첨된 숫자들과 보너스 숫자가 같을 때, 중복을 검증하는 테스트")
    @Test
    void validateDuplicationExceptionTest() {
        // given
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(8);

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new GoldenTicket(winningTicket, bonusNumber));
    }

    @DisplayName("보너스 볼이 들어 있을 때, 포함되었는지 확인하는 테스트")
    @Test
    void containsBonusBallTest() {
        // given
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());

        // when
        boolean isContainBonusBall = goldenTicket.containsBonusBall(lottoTicket);

        // then
        assertThat(isContainBonusBall).isTrue();
    }

    @DisplayName("2등으로 5개의 볼이 맞았을 때, 확인하는 테스트")
    @Test
    void getMatchedNumbersCountTest() {
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());

        // when
        int matchedNumbersCount = goldenTicket.getMatchedNumbersCount(lottoTicket);

        // then
        assertThat(matchedNumbersCount).isEqualTo(5);
    }

    private List<LottoNumber> createPickedWinningNumbers() {
        return Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
    }

    private List<LottoNumber> createPickedSecondNumbers() {
        return Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(45)
        );
    }
}
package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.ErrorCode;
import step3.common.WinningType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {

    private final List<LottoNumber> defaultLottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    );

    @Test
    @DisplayName("당첨 번호 중복 테스트")
    void winningNumbers_shouldThrowDuplicatedException() {
        assertThatThrownBy(()->new WinningNumbers(new Integer[] {1, 1, 3, 4, 5, 6}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("당첨 번호 길이 테스트")
    void winningNumbers_shouldThrowInvalidLengthException() {
        assertThatThrownBy(()->new WinningNumbers(new Integer[] {1, 2, 3}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
    }

    @Test
    @DisplayName("로또 티켓 winningType 테스트")
    void checkWinningType() {
        WinningType winningType;

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // 6개 모두 일치 시에는 1등
        LottoTicket userFirstLottoTicket = new LottoTicket(defaultLottoNumbers);
        winningType = winningNumbers.findWinningType(userFirstLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FIRST);

        // 4개 일치 시에는 3등
        List<LottoNumber> userForthLottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)
        );
        LottoTicket userForthLottoTicket = new LottoTicket(userForthLottoNumbers);
        winningType = winningNumbers.findWinningType(userForthLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FORTH);

        // 0개 일치 시에는 7등
        List<LottoNumber> userSeventhLottoNumbers = Arrays.asList(
                new LottoNumber(11), new LottoNumber(12), new LottoNumber(13),
                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)
        );
        LottoTicket userSeventhLottoTicket = new LottoTicket(userSeventhLottoNumbers);
        winningType = winningNumbers.findWinningType(userSeventhLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.SEVENTH);

    }
}

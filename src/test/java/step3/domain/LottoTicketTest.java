package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.ErrorCode;
import step3.common.WinningType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private final Set<LottoNumber> defaultLottoNumbers = new HashSet<>(Arrays.asList(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    ));


    @Test
    @DisplayName("로또 티켓 길이 확인")
    void lottoTicket_shouldBeSix() {
        // success
        assertThat(new LottoTicket(defaultLottoNumbers)).isInstanceOf(LottoTicket.class);

        // failed
        Set<LottoNumber> failLottoNumber = new HashSet<>();
        for(int i = 1; i <= 4; i++) {
            failLottoNumber.add(new LottoNumber(i));
        }

        assertThatThrownBy(()->new LottoTicket(failLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMEBRS_LENGTH.getErrorMessage());
    }

    @Test
    @DisplayName("로또 티켓 winningType 테스트")
    void checkWinningType() {
        WinningType winningType;

        Set<LottoNumber> winningLottoNumbers = new HashSet<>();
        for(int i = 1; i <= 6; i++) {
            winningLottoNumbers.add(new LottoNumber(i));
        }

        // 6개 모두 일치 시에는 1등
        LottoTicket userFirstLottoTicket = new LottoTicket(defaultLottoNumbers);
        winningType = userFirstLottoTicket.findWinningType(winningLottoNumbers);
        assertThat(winningType).isEqualTo(WinningType.FIRST);

        // 4개 일치 시에는 3등
        Set<LottoNumber> userForthLottoNumbers = new HashSet<>();
        userForthLottoNumbers.add(new LottoNumber(1));
        userForthLottoNumbers.add(new LottoNumber(2));
        userForthLottoNumbers.add(new LottoNumber(3));
        userForthLottoNumbers.add(new LottoNumber(14));
        userForthLottoNumbers.add(new LottoNumber(15));
        userForthLottoNumbers.add(new LottoNumber(16));
        LottoTicket userForthLottoTicket = new LottoTicket(userForthLottoNumbers);
        winningType = userForthLottoTicket.findWinningType(winningLottoNumbers);
        assertThat(winningType).isEqualTo(WinningType.FORTH);

        // 0개 일치 시에는 7등
        Set<LottoNumber> userSeventhLottoNumbers = new HashSet<>();
        userSeventhLottoNumbers.add(new LottoNumber(11));
        userSeventhLottoNumbers.add(new LottoNumber(12));
        userSeventhLottoNumbers.add(new LottoNumber(13));
        userSeventhLottoNumbers.add(new LottoNumber(14));
        userSeventhLottoNumbers.add(new LottoNumber(15));
        userSeventhLottoNumbers.add(new LottoNumber(16));
        LottoTicket userSeventhLottoTicket = new LottoTicket(userSeventhLottoNumbers);
        winningType = userSeventhLottoTicket.findWinningType(winningLottoNumbers);
        assertThat(winningType).isEqualTo(WinningType.SEVENTH);

    }

    @Test
    @DisplayName("로또 티켓 winningType 테스트_잘못된 입력")
    void checkWinningType_throwInvalidLottoNumbersLength() {
        LottoTicket lottoTicket = new LottoTicket(defaultLottoNumbers);
        Set<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2)
        ));

        assertThatThrownBy(()->lottoTicket.findWinningType(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMEBRS_LENGTH.getErrorMessage());

    }

}

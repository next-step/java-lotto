package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.WinningType;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoCheckerTest {

    @Test
    @DisplayName("로또 티켓 winningType 테스트")
    void checkWinningType() {
        LottoChecker lottoChecker = new LottoChecker();
        WinningType winningType = null;

        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));

        // 6개 모두 일치 시에는 1등
        LottoTicket userFirstLottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        winningType = lottoChecker.check(userFirstLottoTicket, winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FIRST);

        // 4개 일치 시에는 3등
        LottoTicket userThirdLottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)
        ));
        winningType = lottoChecker.check(userThirdLottoTicket, winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FORTH);

        // 0개 일치 시에는 7등
        LottoTicket userSeventhLottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(11), new LottoNumber(12), new LottoNumber(13),
                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)
        ));
        winningType = lottoChecker.check(userSeventhLottoTicket, winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.SEVENTH);

    }
}

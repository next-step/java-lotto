package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.WinningType;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoCheckerTest {

    @Test
    @DisplayName("로또 티켓 winningType 테스트")
    void checkWinningType() {
        LottoChecker lottoChecker = new LottoChecker();
        WinningType winningType;

        Set<LottoNumber> firstLottoNumbers = new HashSet<>();
        for(int i = 1; i <= 6; i++) {
            firstLottoNumbers.add(new LottoNumber(i));
        }
        LottoTicket winningLottoTicket = new LottoTicket(firstLottoNumbers);

        // 6개 모두 일치 시에는 1등
        Set<LottoNumber> userFirstLottoNumbers = new HashSet<>();
        for(int i = 1; i <= 6; i++) {
            userFirstLottoNumbers.add(new LottoNumber(i));
        }
        LottoTicket userFirstLottoTicket = new LottoTicket(userFirstLottoNumbers);
        winningType = lottoChecker.check(userFirstLottoTicket, winningLottoTicket);
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
        winningType = lottoChecker.check(userForthLottoTicket, winningLottoTicket);
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
        winningType = lottoChecker.check(userSeventhLottoTicket, winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.SEVENTH);

    }
}

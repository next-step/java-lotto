package lotto.domain.prize;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    List<LottoNumber> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(x -> LottoNumber.create(x))
            .collect(Collectors.toList());
    LottoTicket lottoTicket = LottoTicket.create(1);
    String enteredWinNumber = "1, 2, 3, 4, 5, 6";


    @Test
    void 생성_테스트() {
        assertThatCode(() -> WinningLotto.create(lottoTicket, enteredWinNumber, 10)).doesNotThrowAnyException();
    }

    @Test
    void 당첨번호와_보너스볼_중복확인() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> WinningLotto.create(lottoTicket, enteredWinNumber, 6)
        ).withMessageContaining("보너스 볼이 당첨번호와 중복됩니다.");
    }

    @Test
    void 당첨결과를_생성한다() {
        LottoTicket lottoTicket = LottoTicket.createOne(Arrays.asList(LottoNumbers.create(lottoNumber)));
        WinningLotto winningLotto = WinningLotto.create(lottoTicket, enteredWinNumber, 10);

        WinningResult winningResult = winningLotto.makeWinningResult();
        int winCount = winningResult.tellWinningCount(Rank.FIRST);

        assertThat(winCount).isEqualTo(1);
    }

}

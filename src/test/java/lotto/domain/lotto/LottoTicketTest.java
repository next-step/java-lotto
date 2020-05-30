package lotto.domain.lotto;

import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.number.LottoNumbers;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("LottoTicket 클래스 테스트")
public class LottoTicketTest {

    @DisplayName("입력받은 갯수 만큼 LottoTicket을 생성할 수 있다.")
    @Test
    void createLottoTicket() {
        int lottoCount = 3;
        LottoTicket lottoTicket = new LottoTicket(lottoCount, new LottoNumberGenerator());

        assertAll(
                () -> assertThat(lottoTicket.getLottoNumbers()).hasSize(lottoCount),
                () -> assertThat(lottoTicket.getLottoNumbers().get(0).getClass()).isEqualTo(LottoNumbers.class)
        );
    }

    @DisplayName("WinningNumbers와 매칭 결과(LottoRank)를 반환한다.")
    @Test
    void matchWinningNumber() {
        int lottoCount = 2;
        String winningNumberString = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberString);

        LottoTicket lottoTicket = new LottoTicket(lottoCount, new FixedNumberGenerator());

        Map<LottoRank, Long> lottoRankLongMap = lottoTicket.matchWinningNumber(winningNumbers);

        assertThat(lottoRankLongMap.get(LottoRank.FIRST)).isEqualTo(new Long(lottoCount));
    }
}

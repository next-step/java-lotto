package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Lotto.ofLottoByDesignatedRange;
import static step2.domain.WinnerVerification.getWinnerVerified;

class WinnerVerificationTest {

    @ParameterizedTest
    @CsvSource(value = {"1:7:1,2"}, delimiter = ':')
    public void 당첨_검증_기능(int start, int end, String result) {
        WinnersNo winnersNo = new WinnersNo(result);
        List<Lotto> lottos = Arrays.asList(
                ofLottoByDesignatedRange(start, end),
                ofLottoByDesignatedRange(start, end),
                ofLottoByDesignatedRange(start, end));
        List<WinningInformation> winningInformation = getWinnerVerified(winnersNo, lottos);
        assertThat(winningInformation.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:7:1,2:2"}, delimiter = ':')
    void hasNumber(int start, int end, String winningConditions, int result) {
        WinnersNo winnersNo = new WinnersNo(winningConditions);
        List<Integer> lotteryInfo = ofLottoByDesignatedRange(start, end).getLotteryInfo();
        assertThat(WinnerVerification.hasNumber(winnersNo, lotteryInfo)).isEqualTo(result);
    }
}

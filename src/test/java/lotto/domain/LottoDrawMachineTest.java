package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDrawMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.instance();
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST", "SECOND", "THIRD", "FORTH", "FIFTH"})
    @DisplayName("로또 번호 추첨 테스트")
    void lotto_numbers_draw_test(WinningPrize rank) {
        // given
        LottoNumbers winningLottoNumbers = new LottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 6"));
        WinningLotto winningLotto = new WinningLotto.Builder()
                .winningLottoTicket(lottoMachine.generateManualLottoNumbers(winningLottoNumbers))
                .bonusBall(7)
                .build();

        PublishedLottoTicket publishedLottoTicket = new PublishedLottoTicket.Builder()
                .autoLottoTicketCount(0)
                .manualLottoNumbers(Arrays.asList(
                        "1,2,3,4,5,6",
                        "1,2,3,4,5,45",
                        "1,2,3,4,5,7",
                        "1,2,3,4,44,45",
                        "1,2,3,43,44,45"))
                .build();

        // when
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
        LottoResult lottoResult = lottoDrawMachine.drawLottoResult(winningLotto, publishedLottoTicket);

        // then
        assertThat(lottoResult.getLottoResult().get(rank)).isEqualTo(1);
    }
}

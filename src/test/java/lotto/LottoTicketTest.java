package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinnerPrize;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Test
    void 로또숫자가_중복되지_않는지() {
        LottoTicket lottoTicket = new LottoTicket();
        int distinctSize = (int) lottoTicket.getNumbers()
                .stream()
                .distinct()
                .count();
        assertThat(distinctSize).isEqualTo(LOTTO_NUMBER_COUNT);
    }


    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:3",
                        "1, 3, 5, 7, 8, 10:4",
                        "1, 3, 5, 7, 9, 10:5",
                        "1, 3, 5, 7, 9, 11:6"}, delimiter = ':')
    void 당첨숫자와_일치하는_숫자개수(String input, int expected) {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 3, 5, 7, 9, 11));
        LottoTicket winningNumbers = new LottoTicket(input.split(", "));
        assertThat(lottoTicket.getMatchCount(winningNumbers)).isEqualTo(expected);
    }

    @Test
    void 등수_계산() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(new String[]{"1", "2", "3", "4", "5", "7"}, "6");
        assertThat(winningTicket.rank(lottoTicket)).isEqualTo(WinnerPrize.SECOND);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ",
            "1 2 3 4 5 6",
            "11, 22, 33, 44, 55, 66",
            "1, 2, 3, 4, 5",
            "가, 나, 다, 라, 마, 바"})
    void 적절하지_않은_당첨숫자_생성(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input.split(", ")));
    }

}

package study.step2_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step2.MockLottoNumberGenerator;
import study.step2_1.domain.LottoTicket;
import study.step2_1.domain.WinningRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @ParameterizedTest
    @DisplayName("등수확인 테스트")
    public void checkWinningRankTest(){
        String selectedMyLottoNumbers = "1,2,3,4,5,6";
        LottoTicket winningTicket = new LottoTicket("2,3,4,5,6,7");
        assertThat(new LottoTicket(selectedMyLottoNumbers).checkWinningRank(winningTicket)).isEqualTo(WinningRank.THIRD);
    }
}

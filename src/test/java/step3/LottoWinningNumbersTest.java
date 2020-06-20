package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 당첨 번호 일급 콜렉션 테스트")
public class LottoWinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 생성 에러 테스트")
    void errorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinningNumbers("1,2,3", 4));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinningNumbers("1,2,3,4,5,6,7", 4));

    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복인지 테스트")
    void checkDuplicateBonusTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinningNumbers("1,2,3,4,5,6", 6));
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트")
    void checkWinningTest() {
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers("1,2,3,4,5,6", 7);
        LottoTicket lottoTicket = new LottoTicket(IntStream.range(1, 7).mapToObj(LottoNumber::new).collect(Collectors.toList()));
        List<LottoResult> lottoResults = lottoWinningNumbers.checkLottoWinning(Collections.singletonList(lottoTicket));

        assertThat(lottoResults.get(0).getWinningCount()).isEqualTo(6);
    }
}

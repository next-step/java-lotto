package lotto.domain;

import static lotto.domain.WinningInformation.NO_PRIZE;
import static lotto.domain.WinningInformation.SECOND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInformationTest {

    @Test
    @DisplayName("당첨 번호 개수와 보너스 볼 포함 여부로 WinningInformation 을 찾을 수 있다.")
    void findByMatchingResult() {
        assertThat(WinningInformation.findByMatchingResult(new MatchingResult(5, true))).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("파라미터에 해당하는 WinningInformation 이 없다면 NO_PRIZE 를 반환한다.")
    void findByMatchingResult_noPrize() {
        assertThat(WinningInformation.findByMatchingResult(new MatchingResult(5, true))).isEqualTo(NO_PRIZE);
    }
}
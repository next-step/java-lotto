package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class WinningsStatisticsTest {

    @DisplayName("객체생성")
    @Test
    void create() {
        WinningsStatistics winningsStatistics = new WinningsStatistics(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(35));
        assertThat(winningsStatistics).isInstanceOf(WinningsStatistics.class);
    }

    @DisplayName("보너스번호가 당첨번호에 포함되어 있으면 예외 throw")
    @Test
    void validate_보너스번호가_당첨번호에_포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningsStatistics(new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30)), new LottoNumber(10));
        }).withMessageMatching("당첨번호와 보너스번호가 중복되었습니다.");
    }

    @DisplayName("Result 생성")
    @Test
    void makeStatisticsWinnings_Result_생성() {
        Lottos lottos = new Lottos(
                Collections.singletonList(new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30)))
        );
        Lotto winningLotto = new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30));
        LottoNumber bonusNumber = new LottoNumber(35);
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, bonusNumber);
        assertThat(winningsStatistics.makeStatisticsWinnings(lottos)).isInstanceOf(Result.class);
    }
}

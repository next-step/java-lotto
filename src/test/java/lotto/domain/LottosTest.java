package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("금액에 해당하는 수만큼 자동 로또를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "6000, 6", "14000, 14"})
    void create_only_auto(int money, int expectedCount) {
        assertThat(new Lottos(money).size()).isEqualTo(expectedCount);
    }

    @DisplayName("금액에서 수동 로또 구매를 제외한 수만큼 자동 로또를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1, 0", "1000, 0, 1", "6000, 3, 3"})
    void create_auto_with_manual(int money, int manualCount, int expectedCount) {
        assertThat(new Lottos(money, manualCount).size()).isEqualTo(expectedCount);
    }

    @DisplayName("로또들 컬렉션을 입력받아 Lottos를 생성한다.(수동 로또들 또는 전체)")
    @Test
    void create_only_manual() {
        assertThat(new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).size()).isEqualTo(1);
    }

    @DisplayName("구입 금액 1000원 미만일 경우 IllegalArgumentException을 throw한다.")
    @Test
    public void exception() {
        assertThatThrownBy(() -> new Lottos(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 한 장 이상 구매하세요.");
    }

    @DisplayName("countMatch 함수는 당첨 번호를 받아 전체 발급 로또에 대한 PrizeType 별 count를 통계한 Map을 반환한다.")
    @Test
    void countMatch() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));
        WinningLotto winningLotto = new WinningLotto(numbers, 7);

        // when
        PrizeStatistic prizeStat = lottos.countMatch(winningLotto);

        // then
        assertThat(prizeStat.getOrDefault(PrizeType.FIRST)).isEqualTo(1);
        assertThat(prizeStat.getOrDefault(PrizeType.SECOND)).isEqualTo(1);
    }
}

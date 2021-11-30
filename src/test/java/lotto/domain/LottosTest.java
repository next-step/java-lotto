package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("금액에 해당하는 수만큼 로또를 가진 일급 컬렉션 Lottos를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "6000, 6", "14000, 14"})
    void create(int money, int expectedCount) {
        assertThat(new Lottos(money).getSize()).isEqualTo(expectedCount);
    }

    @DisplayName("구입 금액 1000원 미만일 경우 IllegalArgumentException을 throw한다.")
    @Test
    public void exception() {
        assertThatThrownBy(() -> new Lottos(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 한 장 이상 구매하세요.");
    }

    @DisplayName("countMatch 함수는 당첨 번호를 받아 전체 발급 로또에 대한 PrizeType 별 count를 통계한 Map을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 6000, 14000})
    void countMatch(int money) {
        Lottos lottos = new Lottos(money);
        List<TreeSet> nums = lottos.getLottos().stream()
                .map(lotto -> lotto.getNumbers().getNumbers())
                .collect(Collectors.toList());
        Map<PrizeType, Integer> prizeStat = lottos.countMatch(new Numbers(new ArrayList<Integer>(nums.get(0))));
        assertThat(prizeStat).isInstanceOf(EnumMap.class);
        assertThat(prizeStat.get(PrizeType.FIRST)).isEqualTo(1);
    }
}

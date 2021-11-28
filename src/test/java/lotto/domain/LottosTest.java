package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private final int countFixture = 10;
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private final List<Lotto> lottosFixture = IntStream.range(0, countFixture)
            .mapToObj(i -> new Lotto(new Numbers(numbers)))
            .collect(Collectors.toList());


    @DisplayName("List<Lotto>를 받아 일급 컬렉션 Lottos를 생성한다.")
    @Test
    void create() {
        assertThat(new Lottos(lottosFixture).getSize()).isEqualTo(countFixture);
    }

    @DisplayName("countMatch 함수는 당첨 번호를 받아 전체 발급 로또에 대한 PrizeType 별 count를 통계한 Map을 반환한다.")
    @Test
    void countMatch() {
        List<Integer> prizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<PrizeType, Integer> prizeStat = new Lottos(lottosFixture).countMatch(new Numbers(prizeNumbers));
        assertThat(prizeStat.get(PrizeType.FIRST)).isEqualTo(countFixture);
    }
}

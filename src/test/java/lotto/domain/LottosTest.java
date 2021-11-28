package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private final int countFixture = 10;
    private final List<Lotto> lottosFixture = IntStream.range(0, countFixture).mapToObj(i -> new Lotto()).collect(Collectors.toList());

    @DisplayName("List<Lotto>를 받아 일급 컬렉션 Lottos를 생성한다.")
    @Test
    void create() {
        assertThat(new Lottos(lottosFixture).getSize()).isEqualTo(countFixture);
    }
}

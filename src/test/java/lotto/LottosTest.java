package lotto;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottosTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto((Arrays.asList(1, 2, 3, 4, 5, 6)).stream()
            .map(i -> LottoNumber.of(i))
            .collect(toList()));
    }

    @ParameterizedTest(name = "추가 테스트")
    @ValueSource(strings = {"1", "5", "45"})
    public void add(int input) {
        // given
        Lottos lottos = new Lottos();
        for (int i = 0; i < input; i++) {
            lottos.add(lotto);
        }
        // when & then
        assertThat(lottos.lottos().size()).isEqualTo(input);
    }
}

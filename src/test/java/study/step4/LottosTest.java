package study.step4;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step4.domain.Lotto;
import study.step4.domain.LottoNumber;
import study.step4.domain.Lottos;

public class LottosTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto((Arrays.asList(1,2,3,4,5,6)).stream()
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
        assertThat(lottos.getLottos().size()).isEqualTo(input);
    }

    @ParameterizedTest(name = "결과 테스트")
    @CsvSource(value = {"1,2,3,10,11,12:5000", "1,2,3,4,10,11:50000", "1,2,3,4,5,10:1500000", "1,2,3,4,5,6:2000000000"}, delimiter = ':')
    public void result(String input, int expcted) {
        // given
        Lottos lottos = new Lottos();
        lottos.add(lotto);

        Lotto winLotto = new Lotto(Arrays.stream(input.split(","))
            .map(i -> LottoNumber.of(i))
            .collect(toList()));
        // when
        int sum = lottos.result(winLotto, null).sum();
        // then
        assertThat(sum).isEqualTo(expcted);
    }
}

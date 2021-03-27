package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step3.domain.Lotto;
import study.step3.domain.LottoNumber;
import study.step3.domain.Lottos;

public class LottosTest {

    @ParameterizedTest(name = "추가 테스트")
    @ValueSource(strings = {"1", "5", "45"})
    public void add(int input) {
        // given
        Lottos lottos = new Lottos();
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(LottoNumber.of(1));
        for (int i = 0; i < input; i++) {
            lottos.add(new Lotto(lottoNumbers));
        }

        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(input);
    }

    @ParameterizedTest(name = "결과 테스트")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void result(int input, int expcted) {
        // given
        Lottos lottos = new Lottos();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(1, input + 1).forEach(i -> {
            lottoNumbers.add(LottoNumber.of(i));
        });
        lottos.add(new Lotto(lottoNumbers));

        // when
        int sum = lottos.result(new Lotto(lottoNumbers), null).sum();

        // then
        assertThat(sum).isEqualTo(expcted);
    }
}

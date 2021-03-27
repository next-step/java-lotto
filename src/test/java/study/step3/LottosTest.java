package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.step3.domain.Lotto;
import study.step3.domain.LottoNumber;
import study.step3.domain.Lottos;

public class LottosTest {
    @ParameterizedTest(name = "추가 테스트")
    @ValueSource(strings = {"1", "45"})
    public void add(int input) {
        Lottos lottoList = new Lottos();
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        IntStream.range(1, 5).forEach(i -> {
            lottoNumberList.add(LottoNumber.of(i));
        });
        for(int i = 0; i < input; i++) {
            lottoList.add(new Lotto(lottoNumberList));
        }
        assertThat(lottoList.getLottos().size()).isEqualTo(input);
    }
}

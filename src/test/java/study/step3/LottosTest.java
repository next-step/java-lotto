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
    @ValueSource(strings = {"1", "45"})
    public void add(int input) {
        // input
        Lottos lottoList = new Lottos();
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        IntStream.range(1, 6).forEach(i -> {
            lottoNumberList.add(LottoNumber.of(i));
        });
        for(int i = 0; i < input; i++) {
            lottoList.add(new Lotto(lottoNumberList));
        }
        // when & then
        assertThat(lottoList.getLottos().size()).isEqualTo(input);
    }

    @ParameterizedTest(name = "결과 테스트")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void result(int input, int expected) {
        // input
        Lottos lottoList = new Lottos();
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        IntStream.range(1, input + 1).forEach(i -> {
            lottoNumberList.add(LottoNumber.of(i));
        });
        lottoList.add(new Lotto(lottoNumberList));

        List<LottoNumber> winLottoNumberList = new ArrayList<>();
        IntStream.range(1, input + 1).forEach(i -> {
            winLottoNumberList.add(LottoNumber.of(i));
        });
        Lotto winLotto = new Lotto(winLottoNumberList);

        // when & then
        assertThat(lottoList.result(winLotto, null).sum()).isEqualTo(expected);

    }
}

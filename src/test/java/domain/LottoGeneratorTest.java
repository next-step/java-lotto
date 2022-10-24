package domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 금액에_해당하는_로또를_발급한다() {
        assertThat(LottoGenerator.getInstance().generateLotto(new Price(6000))).hasSize(6);
    }

    @Test
    void 로또생성기는_여섯개의_숫자를_가진_로또를_생성한다() {
        assertThat(LottoGenerator.getInstance().generateNumbers()).hasSize(6);
    }

    @Test
    void 당첨_로또를_생성한다() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());


        assertThat(LottoGenerator.getInstance().generateLotto(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void 보너스볼을_포함한_로또를_생성한다() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        int bonus = 7;

        assertThat(LottoGenerator.getInstance().generateWinningLotto(List.of(1,2,3,4,5,6), bonus)).isEqualTo(new WinningLotto(lottoNumbers, new LottoNumber(bonus)));
    }
}

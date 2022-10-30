package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    public static final LottoGenerator LOTTO_GENERATOR = LottoGenerator.getInstance();

    @Test
    void 금액에_해당하는_로또를_발급한다() {
        assertThat(LOTTO_GENERATOR.generateLotto(new Price(6000))).hasSize(6);
    }

    @Test
    void 로또생성기는_여섯개의_숫자를_가진_로또를_생성한다() {
        assertThat(LOTTO_GENERATOR.generateNumbers()).hasSize(6);
    }

    @Test
    void 당첨_로또를_생성한다() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());


        assertThat(LOTTO_GENERATOR.generateLotto(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void 보너스볼을_포함한_로또를_생성한다() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        int bonus = 7;

        assertThat(LOTTO_GENERATOR.generateWinningLotto(List.of(1,2,3,4,5,6), bonus)).isEqualTo(new WinningLotto(lottoNumbers, new LottoNumber(bonus)));
    }

    @Test
    void 수동으로_로또를_생성한다() {
        int numberOfManualLotto = 3;
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        manualLottoNumbers.add(lottoNumbers);
        manualLottoNumbers.add(lottoNumbers);
        manualLottoNumbers.add(lottoNumbers);

        assertThat(LOTTO_GENERATOR.generateLotto(numberOfManualLotto, manualLottoNumbers)).hasSize(numberOfManualLotto);
    }

    @Test
    void 수동으로_로또를_생성할때_개수와_번호의수가_일치하지않으면_예외를뱉는다() {
        int numberOfManualLotto = 2;
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        manualLottoNumbers.add(lottoNumbers);
        manualLottoNumbers.add(lottoNumbers);
        manualLottoNumbers.add(lottoNumbers);

        assertThatThrownBy(() -> {
            assertThat(LOTTO_GENERATOR.generateLotto(numberOfManualLotto, manualLottoNumbers)).hasSize(numberOfManualLotto);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

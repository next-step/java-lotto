package lotto.domain.generator;

import lotto.domain.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HalfManualLottoGeneratorTest {

    @Test
    public void 로또번호_문자열로_HalfManualLottoGenerator_생성하면_수동_생성() {
        // given
        LottoGenerator lottoGenerator = new HalfManualLottoGenerator("1, 2, 3, 4, 5, 6");

        // when
        Lotto generatedLotto = lottoGenerator.generate();

        // then
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isEqualTo(generatedLotto)).isTrue();
    }

    @Test
    public void 지정한_만큼_LottoBundle_생성() {
        // given
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 15, 16");
        long numberOfAutoLottos = 3;

        // when
        LottoBundle lottoBundle = HalfManualLottoGenerator.generateLottoBundle(manualLottos, numberOfAutoLottos);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(5);
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}

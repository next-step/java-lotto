package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoGeneratorTest {
    @Test
    public void 로또_수동_생성() {
        // given
        String lottoString = "1, 2, 3, 4, 5, 6";
        LottoGenerator lottoGenerator = new ManualLottoGenerator(lottoString);

        // when
        Lotto generatedLotto = lottoGenerator.generate();

        // then
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(generatedLotto.isEqualTo(lotto)).isTrue();
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}

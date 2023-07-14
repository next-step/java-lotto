package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @Test
    @DisplayName("중복되지 않는 6개의 수와 1부터 45 범위를 가지는 로또를 생성한다")
    void 자동_로또_생성() {
        // given
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();

        // when
        Lotto lotto = autoLottoGenerator.generate();

        // then
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for (var lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }

}

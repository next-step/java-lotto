package lotto;

import lotto.domain.LottoNumbers;
import lotto.utils.LottoGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {

    @Test
    void 로또번호_생성_범위_테스트() {
        //given
        LottoNumbers lottoNumbers = LottoGenerator.generateLottoNumbers();

        //when
        //then
        assertThat(lottoNumbers.value().stream().allMatch(v -> v.value() >= 1 && v.value() <= 45)).isTrue();
    }

    @Test
    void 로또번호_생성_개수_테스트() {
        //given
        LottoNumbers lottoNumbers = LottoGenerator.generateLottoNumbers();

        //when
        //then
        assertThat(lottoNumbers.value().size()).isEqualTo(6);
    }
}

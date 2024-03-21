package lotto.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.common.ConstantSet.MIN_LOTTO_NUMBER;
import static lotto.common.ConstantSet.MAX_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("리턴하는 리스트의 크기는 6이여야 한다.")
    void 테스트(){
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<LottoNumber> list = generator.generateRandomLottoNumbers();
        assertThat(list.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("리턴하는 리스트의 범위는 1~45 이여야 한다.")
    void testGenerateRandomLottoNumbers_Range() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = generator.generateRandomLottoNumbers();
        assertThat(lottoNumbers)
                .allMatch(num -> num.getLottoNumber() >= MIN_LOTTO_NUMBER && num.getLottoNumber() <= MAX_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("같은 리스트가 반환되서는 안된다_1/5864443200의 확률로 중복 가능성이 낮음")
    void testGenerateRandomLottoNumbers_Randomness() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<LottoNumber> firstDraw = generator.generateRandomLottoNumbers();
        List<LottoNumber> secondDraw = generator.generateRandomLottoNumbers();
        assertThat(firstDraw).isNotEqualTo(secondDraw);
    }
}

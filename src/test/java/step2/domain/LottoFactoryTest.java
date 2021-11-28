package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @DisplayName("생성된 로또 번호는 6개이다.")
    @Test
    void create() {
        Lotto lotto = LottoFactory.create();
        int lottoNumbersSize = lotto.getLottoNumbers().size();
        assertThat(lottoNumbersSize).isEqualTo(6);
    }

    @DisplayName("생성된 로또 번호는 1~45중 하나다.")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void lottoNumberRangeCheck(int lottoNumber) {
        assertThat(lottoNumber).isGreaterThan(0);
        assertThat(lottoNumber).isLessThan(46);
    }

    private static List<Integer> generateLottoNumbers() {
        return LottoFactory.create().getLottoNumbers();
    }


}
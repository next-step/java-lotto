package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.LottoNumbersUtil;

/**
 * Lottos 클래스 생성 및 기능 테스트
 */
public class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("생성된 로또의 개수 확인")
    void check_lotto_count(int size) {
        // given
        List<LottoNumbers> inputLottos = new ArrayList<>();

        // when
        for (int i = 0; i < size; i++) {
            inputLottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));
        }
        Lottos lottos = new Lottos(inputLottos);

        // then
        assertThat(lottos.getSize()).isEqualTo(size);
    }

    @Test
    @DisplayName("객체 생성")
    void create() {
        // given
        List<LottoNumbers> inputLottos = new ArrayList<>();

        // when
        inputLottos.add(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"));
        Lottos lottos = new Lottos(inputLottos);

        // then
        assertThat(lottos.getLottoNumbers(0)).isNotNull();
    }
}

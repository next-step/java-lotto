package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumTest {

    @Test
    @DisplayName("로또 숫자 정렬 테스트")
    void 로또_숫자_정렬() {
        LottoNum lotto3 = LottoNum.valueOf(3);
        LottoNum lotto2 = LottoNum.valueOf(2);
        List<LottoNum> lottoNums = Arrays.asList(lotto3, lotto2);
        Collections.sort(lottoNums);
        assertThat(lottoNums.get(0)).isEqualTo(lotto2);
        assertThat(lottoNums.get(1)).isEqualTo(lotto3);
    }

    @Test
    @DisplayName("로또 전체 리스트를 반환한다.")
    void 로또_전체_리스트() {
        assertThat(LottoNum.getLottoNumbers()).hasSize(45);
    }

    @ParameterizedTest
    @DisplayName("숫자의 범위가 1~45를 벗어나면 예외를 발생시킨다.")
    @ValueSource(ints = {0, 46})
    void 로또_숫자_범위_예외(int number) {
        assertThatThrownBy(() -> LottoNum.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

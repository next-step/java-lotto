package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

class LottoTotalNumberUtilsTest {

    @DisplayName(value = "로또를 선택하기 위한 1 ~ 45의 숫자가 있는지 사이즈 확인")
    @Test
    void 로또_전체_번호_크기() {
        // given
        Collection<Integer> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();
        
        // when
        int size = lottoTotalNumbers.size();

        // then
        assertThat(size).isEqualTo(45);
    }

    @DisplayName(value = "로또를 선택하기 위한 1 ~ 45의 숫자가 모두 있는지 확인")
    @Test
    void 로또_전체_번호_체크() {
        // given
        Collection<Integer> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();

        // when
        Collection<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 45 ; i++) {
            expected.add(i);
        }

        // then
        assertThat(lottoTotalNumbers).isEqualTo(expected);
    }
}
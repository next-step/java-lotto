package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTotalNumberUtilsTest {

    @DisplayName(value = "로또를 선택하기 위한 1 ~ 45의 숫자가 있는지 사이즈 확인")
    @Test
    void 로또_전체_번호_크기() {
        // given
        List<Number> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();

        // when
        int size = lottoTotalNumbers.size();

        // then
        assertThat(size).isEqualTo(LottoTotalNumberUtils.LOTTO_NUMBER_MAXIMUM);
    }

    @DisplayName(value = "로또를 선택하기 위한 1 ~ 45의 숫자가 모두 있는지 확인")
    @Test
    void 로또_전체_번호_체크() {
        // given
        List<Number> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();
        Collections.sort(lottoTotalNumbers);

        // when
        List<Number> expected = new ArrayList<>();
        for (int i = LottoTotalNumberUtils.LOTTO_NUMBER_MINIMUM; i <= LottoTotalNumberUtils.LOTTO_NUMBER_MAXIMUM; i++) {
            expected.add(Number.newNumber(i));
        }

        // then
        assertThat(lottoTotalNumbers).isEqualTo(expected);
    }
}
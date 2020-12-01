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
        Collection<Integer> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();
        
        // when
        int size = lottoTotalNumbers.size();

        // then
        assertThat(size).isEqualTo(45);
    }

    // 1 ~ 45가 전부 유효한지만 체크하는 메서드 없나? Assertj 문서를 못보겠다. ㅜ.ㅜ
    @DisplayName(value = "로또를 선택하기 위한 1 ~ 45의 숫자가 모두 있는지 확인")
    @Test
    void 로또_전체_번호_체크() {
        // given
        List<Integer> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();
        Collections.sort(lottoTotalNumbers);
        System.out.println("lottoTotalNumbers = " + lottoTotalNumbers);

        // when
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            expected.add(i);
        }

        // then
        assertThat(lottoTotalNumbers).isEqualTo(expected);
    }
}
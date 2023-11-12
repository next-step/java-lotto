package lotto.step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @RepeatedTest(3)
    @DisplayName("로또 번호를 만들면, 1이상 45이하의 중복되지 않은 6개의 수를 반환한다.")
    void testLottoHasUniqueSixNumbersWhichAre1to45() {
        //given
        //when
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();

        //then
        assertThat(lottoNumbers).hasSize(6)
                .allMatch(number -> 1 <= number && number <= 45);
    }

    @RepeatedTest(3)
    @DisplayName("로또 번호는 오름차순으로 정렬이 되어있다.")
    void testLottoNumbersAreSorted() {
        //given
        //when
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
        List<Integer> lottoNumberList = new ArrayList<>(lottoNumbers);

        //then
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            assertThat(lottoNumberList.get(i)).isLessThan(lottoNumberList.get(i + 1));
        }
    }
}

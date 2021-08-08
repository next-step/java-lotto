package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.strategy.ListSortStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    @DisplayName("정렬전략 로또생성기에서 getLottoNumbers 함수를 호출하면 1~6의 로또넘버 객체를 리턴한다.")
    void getLottoNumbers(int number) {
        LottoNumbers lottoNumbers = LottoNumberGenerator.getLottoNumbers(new ListSortStrategy());
        assertTrue(lottoNumbers.getLottoNumbers().contains(new LottoNumber(number)));
    }
}
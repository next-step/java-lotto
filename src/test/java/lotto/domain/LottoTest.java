package lotto.domain;

import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    /**
     *     - Lotto
     *     - 생성 시 LottoNumber의 배열이 6자리가 아니면 runtime exception
     *     - compare() 비교 후 일치하는 숫자의 갯수를 반환
     *     - LottoNumber 배열 sort()
     */

    @DisplayName("LottoNumber의 배열이 6자리가 아니면 runtime exception")
    @ParameterizedTest
    @ValueSource(strings = {"1","1,2","1,2,3","1,2,3,4","1,2,3,4,5"})
    void notNumberTest(String input) {
        List<LottoNumber> lottoNumberList = createLottoNumberList(input);
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.create(lottoNumberList));
    }

    private List<LottoNumber> createLottoNumberList(String input) {
        return Arrays.stream(input.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList());
    }

}
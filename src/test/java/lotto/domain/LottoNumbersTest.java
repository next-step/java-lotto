package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private List<LottoNo> originNumbers;

    @BeforeEach
    void makeNumbers(){
        originNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            originNumbers.add(LottoNo.of(i));
        }
    }

    @Test
    void 입력숫자6개초과시_예외처리() {
        originNumbers.add(LottoNo.of(7));
        assertThatThrownBy(() -> new LottoNumbers(originNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 선택한 숫자가 맞음")
    @ValueSource(ints = {1,2,3,4,5,6})
    void 숫자포함테스트(int number) {
        LottoNumbers lottoNumbers = new LottoNumbers(originNumbers);
        assertThat(lottoNumbers.contains(LottoNo.of(number))).isTrue();
    }

    @ParameterizedTest(name = "{0}은 선택한 숫자가 아님")
    @ValueSource(ints = {41,42,43,44,45})
    void 숫자불포함테스트(int number) {
        LottoNumbers lottoNumbers = new LottoNumbers(originNumbers);
        assertThat(lottoNumbers.contains(LottoNo.of(number))).isFalse();
    }
}

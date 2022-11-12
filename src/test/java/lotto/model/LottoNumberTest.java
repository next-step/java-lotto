package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.*;

import static lotto.model.LottoNumber.LOTTO_END_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

class LottoNumberTest {

    @Test
    @DisplayName("하나의 인스턴스만 보장한다")
    void create() {
        assertSame(LottoNumber.getCachedNumber(3), LottoNumber.getCachedNumber(3));
    }

    @Test
    @DisplayName("45개의 숫자들이 저장되어있다")
    void size() {
        assertThat(LottoNumber.cache().size()).isEqualTo(45);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,false", "46,false", "1,true", "45,true"})
    @DisplayName("1부터 45까지의 숫자들이 저장되어있다")
    void boundary(int element, boolean expected) {
        assertThat(LottoNumber.cache().containsKey(element)).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또번호는 중복되지않는 45개이다.")
    void size2() {
        Set<Integer> testSet = new HashSet<>(new ArrayList<>(LottoNumber.cache().keySet()));
        assertThat(testSet.size()).isEqualTo(LOTTO_END_NUMBER);
    }
}
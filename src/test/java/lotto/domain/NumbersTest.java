package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("로또 번호는 6개여야 한다")
    void lottoNumberLengthTest() {
        Numbers numbers = new Numbers(Arrays.asList(1,2,3,4,5,6));
        assertEquals(6, numbers.getLottoNumbers().size());
    }

    @Test
    @DisplayName("로또 번호는 1부터 45사이여야 한다")
    void lottoNumberRangeOfSignificantDigitsTest() {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(Arrays.asList(1,2,3,4,5,46)));
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    void duplicateLottoNumberExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(Arrays.asList(1,2,3,4,5,5)));
    }

}
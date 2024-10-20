package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    void createLotto_inputValidation(int[] testNumbers) {
        assertThatThrownBy(() -> getLotto(testNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_length() {
        assertThatThrownBy(() -> getLotto(new int[]{1,2,3,4,5})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_duplication() {
        assertThatThrownBy(() -> getLotto(new int[]{1,2,3,4,5,5})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_range() {
        assertThatThrownBy(() -> getLotto(new int[]{1,2,3,4,5,50})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void contains() {
        assertThat(getLotto(new int[]{1, 2, 3, 4, 5, 6}).contains(new LottoNumber(3))).isTrue();
    }

    @Test
    void eqauls() {
        assertThat(getLotto(new int[]{1, 2, 3, 4, 5, 6}).equals(new Lotto(new LottoNumbers(new int[]{1,2,3,4,5,6}))));
    }
    private Lotto getLotto(int[] numbers) {
        Lotto lotto = new Lotto(new LottoNumbers(numbers));
        return lotto;
    }
}

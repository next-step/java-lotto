package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또는 동일한 번호의 갯수를 반환한다.")
    @Test
    void getRightNumberTest() {
        final Set<Integer> numbers = new HashSet<>();
        numbers.add(3);
        numbers.add(5);
        final Lotto lotto = new Lotto(new LottoNumbers(numbers));

        final int rightNumber = lotto.getRightNumber(Arrays.asList(3));

        assertThat(rightNumber).isEqualTo(1);
    }

}
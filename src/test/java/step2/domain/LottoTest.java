package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoTest {

    @Test
    void test001() {
        List<Integer> shuffledNumbers = Arrays.asList(45,44,43,42,41,40);

        Lotto lotto = new Lotto(new ReverseLottoNumberGenerator());
        List<Integer> numbers = lotto.getNumbers();

        Assertions.assertTrue(shuffledNumbers.containsAll(numbers));
    }

}
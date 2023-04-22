package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호는 1~45까지의 범위의 수만 생성해야 합니다.")
    void test01() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Set<Integer> numberSet = new HashSet<>();

        IntStream.range(0, 10000).forEach(n -> {
            numberSet.add(lottoNumberGenerator.generate());
        });

        assertThatNoException().isThrownBy(() -> validateSet(numberSet));
    }

    private static void validateSet(Set<Integer> numberSet) {
        System.out.println(numberSet);
        numberSet.forEach(LottoNumberGeneratorTest::validate);
    }

    private static void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalStateException();
        }
    }

}
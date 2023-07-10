package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersGeneratorTest {

    @Test
    void 싱글톤객체인_RandomNumberGenerator객체_반환_성공() {
        // given, when, then
        assertDoesNotThrow(RandomNumbersGenerator::getInstance);
    }

    // 1. 랜덤(1~45)
    // 2, 숫자 6개
    // 3. 중복 안 됨
    // 4. 정렬
    @Test
    void 숫자들의_범위가_1이상_45이하_성공() {
        // given
        RandomNumbersGenerator randomNumbersGenerator = RandomNumbersGenerator.getInstance();

        // when
        List<Integer> numbers = randomNumbersGenerator.generate();

        // then
        assertThat(numbers).allSatisfy(number ->
                assertThat(number)
                        .isGreaterThanOrEqualTo(1)
                        .isLessThanOrEqualTo(45)
        );
    }

    @Test
    void 생성된_숫자의_갯수가_6개면_성공() {
        // given
        RandomNumbersGenerator randomNumbersGenerator = RandomNumbersGenerator.getInstance();

        // when
        List<Integer> numbers = randomNumbersGenerator.generate();

        // then
        assertThat(numbers).hasSize(6);
    }

    @Test
    void 생성된_숫자들이_중복되지_않으면_성공() {
        // given
        RandomNumbersGenerator randomNumbersGenerator = RandomNumbersGenerator.getInstance();

        // when
        List<Integer> numbers = randomNumbersGenerator.generate();

        // then
        assertThat(numbers).hasSameSizeAs(new HashSet<>(numbers));
    }
}

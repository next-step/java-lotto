package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SixSingleNumberTest {
    @Test
    @DisplayName("[SixNumberComposition] 정상 생성")
    void testValidNumberListCreatesObject() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> {
            SixNumberComposition.ofByInt(numbers);
        });
    }

    @Test
    @DisplayName("[SixNumberComposition] 숫자 5개로 생성 시 -> 예외 던짐")
    void testInvalidLengthThrowsException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    SixNumberComposition.ofByInt(numbers);
                });
    }

    @Test
    @DisplayName("[SixNumberComposition] 1 미만 주어졌을 때 -> 예외 던짐")
    void testOutOfRangeNumberThrowsException() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    SixNumberComposition.ofByInt(numbers);
                });
    }

    @Test
    @DisplayName("[SixNumberComposition] 중복 숫자 있을 때 -> 예외 던짐")
    void testDuplicateNumberThrowsException() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    SixNumberComposition.ofByInt(numbers);
                });
    }

    @Test
    @DisplayName("[SixNumberComposition.equals] 같은 숫자 조합일 때 -> 동일 판정")
    void testEqualsAndHashCode() {
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(6, 5, 4, 3, 2, 1);
        SixNumberComposition composition1 = SixNumberComposition.ofByInt(numbers1);
        SixNumberComposition composition2 = SixNumberComposition.ofByInt(numbers2);

        assertThat(composition1).isEqualTo(composition2);
        assertThat(composition1.hashCode()).isEqualTo(composition2.hashCode());
    }

    @Test
    @DisplayName("[SixNumberComposition.contains] 숫자 찾기")
    void testContainsMethod() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        SixNumberComposition composition = SixNumberComposition.ofByInt(numbers);

        assertThat(composition.contains(SingleNumber.of(1))).isTrue();
        assertThat(composition.contains(SingleNumber.of(7))).isFalse();
    }
}

package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Collections 학습 테스트")
class CollectionsTest {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 5;
    private static final List<Integer> ASCENDING_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());

    @DisplayName("깊은 복사 테스트")
    @Test
    void copyDeeplyTest() {
        // when
        List<Integer> destination1 = new ArrayList<>(ASCENDING_NUMBERS);
        List<Integer> destination2 = new ArrayList<>(ASCENDING_NUMBERS.size());
        destination2.addAll(ASCENDING_NUMBERS);
        // then
        assertAll(
                () -> assertThat(destination1).isEqualTo(ASCENDING_NUMBERS),
                () -> assertThat(destination2).isEqualTo(ASCENDING_NUMBERS)
        );
    }

    @DisplayName("섞기 테스트")
    @Test
    void shuffleTest() {
        // given
        List<Integer> copySource = new ArrayList<>(ASCENDING_NUMBERS);
        // when
        Collections.shuffle(copySource);
        Collections.shuffle(copySource);
        // then
        assertAll(
                () -> assertThat(copySource).isNotEqualTo(ASCENDING_NUMBERS),
                () -> assertThat(ASCENDING_NUMBERS.containsAll(copySource)).isTrue()
        );
    }

    @DisplayName("정렬 테스트")
    @Test
    void sortTest() {
        // given
        List<Integer> copiedAscendingSource = new ArrayList<>(ASCENDING_NUMBERS);
        Collections.shuffle(copiedAscendingSource);
        // when
        Collections.sort(copiedAscendingSource); // default sorting : ascending order
        // then
        assertThat(copiedAscendingSource).isEqualTo(ASCENDING_NUMBERS);
    }

    @DisplayName("포함 여부 테스트")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    void containsTest(int validNumber) {
        // when
        boolean actual = ASCENDING_NUMBERS.contains(validNumber);
        // then
        assertThat(actual).isTrue();
    }

    private static List<Integer> provideValidNumbers() {
        return ASCENDING_NUMBERS;
    }
}

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

@DisplayName("Collections 사용법을 확인하기 위한 테스트")
class CollectionsTest {

    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 5;
    static final List<Integer> ASCENDING_SOURCE = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());

    @DisplayName("깊은 복사 테스트")
    @Test
    void copyDeeplyTest() {
        // When
        List<Integer> destination1 = new ArrayList<>(ASCENDING_SOURCE);
        List<Integer> destination2 = new ArrayList<>(ASCENDING_SOURCE.size());
        destination2.addAll(ASCENDING_SOURCE);
        // Then
        assertAll(
                () -> assertThat(destination1).isEqualTo(ASCENDING_SOURCE),
                () -> assertThat(destination2).isEqualTo(ASCENDING_SOURCE)
        );
    }

    @DisplayName("섞기 테스트")
    @Test
    void shuffleTest() {
        // Given
        List<Integer> copySource = new ArrayList<>(ASCENDING_SOURCE);
        // When
        Collections.shuffle(copySource);
        Collections.shuffle(copySource);
        // Then
        assertAll(
                () -> assertThat(copySource).isNotEqualTo(ASCENDING_SOURCE),
                () -> assertThat(ASCENDING_SOURCE.containsAll(copySource)).isTrue()
        );
    }

    @DisplayName("정렬 테스트")
    @Test
    void sortTest() {
        // Given
        List<Integer> copiedAscendingSource = new ArrayList<>(ASCENDING_SOURCE);
        Collections.shuffle(copiedAscendingSource);
        // When
        Collections.sort(copiedAscendingSource); // default sorting : ascending order
        // Then
        assertThat(copiedAscendingSource).isEqualTo(ASCENDING_SOURCE);
    }

    @DisplayName("포함 여부 테스트")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    void containsTest(int validNumber) {
        // When
        boolean actual = ASCENDING_SOURCE.contains(validNumber);
        // Then
        assertThat(actual).isTrue();
    }

    static List<Integer> provideValidNumbers() {
        return ASCENDING_SOURCE;
    }
}

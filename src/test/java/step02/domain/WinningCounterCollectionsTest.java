package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningCounterCollectionsTest {
    List<WinningCounter> numbersCount;

    @BeforeEach
    public void setup() {
        numbersCount = Arrays.asList(
                WinningCounter.of(0, 7),
                WinningCounter.of(1, 5),
                WinningCounter.of(2, 1),
                WinningCounter.of(3, 1)
        );
    }

    @DisplayName("NumberCountCollections 생성자 테스트")
    @Test
    public void test_NumberCountCollections_Constructor() {
        assertThat(WinningCounterCollections.of(numbersCount))
                .isEqualTo(WinningCounterCollections.of(numbersCount));
    }

    @DisplayName("NumberCountCollections 필터링 테스트")
    @Test
    public void test_filter() {
        WinningCounterCollections winningCounterCollections = WinningCounterCollections.of(numbersCount);
        assertThat(winningCounterCollections.filter(3, 6))
                .isEqualTo(
                    Arrays.asList(WinningCounter.of(3, 1))
                );
    }
}

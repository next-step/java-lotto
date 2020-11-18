package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumberCountCollectionsTest {
    List<NumberCount> numbersCount;

    @BeforeEach
    public void setup() {
        numbersCount = Arrays.asList(
                NumberCount.of(0, 7),
                NumberCount.of(1, 5),
                NumberCount.of(2, 1),
                NumberCount.of(3, 1)
        );
    }

    @DisplayName("NumberCountCollections 생성자 테스트")
    @Test
    public void test_NumberCountCollections_Constructor() {
        assertThat(NumberCountCollections.of(numbersCount))
                .isEqualTo(NumberCountCollections.of(numbersCount));
    }

    @DisplayName("NumberCountCollections 필터링 테스트")
    @Test
    public void test_filter() {
        NumberCountCollections numberCountCollections = NumberCountCollections.of(numbersCount);
        assertThat(numberCountCollections.filter(3, 6))
                .isEqualTo(
                    Arrays.asList(NumberCount.of(3, 1))
                );
    }
}

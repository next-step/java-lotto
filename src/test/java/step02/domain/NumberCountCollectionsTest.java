package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumberCountCollectionsTest {
    @DisplayName("NumberCountCollections 생성자 테스트")
    @Test
    public void test_NumberCountCollections_Constructor() {
        List<NumberCount> numbersCount = Arrays.asList(
                NumberCount.of(0, 7),
                NumberCount.of(1, 5),
                NumberCount.of(2, 1),
                NumberCount.of(3, 1)
        );
        assertThat(NumberCountCollections.of(numbersCount))
                .isEqualTo(NumberCountCollections.of(numbersCount));
    }
}

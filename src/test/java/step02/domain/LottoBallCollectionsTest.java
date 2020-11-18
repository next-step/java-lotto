package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoBallCollectionsTest {
    List<LottoBall> numbersCount;

    @BeforeEach
    public void setup() {
        numbersCount = Arrays.asList(
                LottoBall.of(0, 7),
                LottoBall.of(1, 5),
                LottoBall.of(2, 1),
                LottoBall.of(3, 1)
        );
    }

    @DisplayName("NumberCountCollections 생성자 테스트")
    @Test
    public void test_NumberCountCollections_Constructor() {
        assertThat(LottoBallCollections.of(numbersCount))
                .isEqualTo(LottoBallCollections.of(numbersCount));
    }

    @DisplayName("NumberCountCollections 필터링 테스트")
    @Test
    public void test_filter() {
        LottoBallCollections lottoBallCollections = LottoBallCollections.of(numbersCount);
        assertThat(lottoBallCollections.filter(3, 6))
                .isEqualTo(
                    Arrays.asList(LottoBall.of(3, 1))
                );
    }
}

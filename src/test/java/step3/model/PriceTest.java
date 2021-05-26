package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceTest {

    @ParameterizedTest
    @DisplayName("가격은 0보다 크며, 1000단위만 가능하다.")
    @ValueSource(ints = {-1, 100, 1100})
    void createTest(int price) {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> {
                new Price(price);
            });

        assertThat(exception.getMessage())
            .isEqualTo("가격은 0보다 크며, 1000단위만 가능합니다.");
    }

    @Test
    @DisplayName("가격에 대한 총 로또 구매 횟수 반환 테스트")
    void countTest() {
        Price price = new Price(14000);
        assertThat(price.getBuyCountStream().count()).isEqualTo(14);

    }

    @Test
    @DisplayName("가격보다 수동으로 구매한 로또수가 클 경우 에러 발생 테스트")
    void createWithManual() {

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> {
                new Price(14000, 100);
            });

        assertThat(exception.getMessage())
            .isEqualTo("가격에 맞는 수동 구매 로또 수를 입력하세요");

    }

}

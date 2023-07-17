package lotto;

import lotto.domain.Count;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    @DisplayName("개수를 생성한다.")
    void create() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Count(0));
    }

    @Test
    @DisplayName("음수 입력시 생성자가 예외를 던진다.")
    void validatePositive() {
        Assertions.assertThatThrownBy(() -> new Count(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("count번 반복할 수 있는 스트림을 반환한다.")
    void stream() {
        int value = 5;
        Count count = new Count(5);

        Assertions.assertThat(count.stream().count()).isEqualTo(value);
    }

    @Test
    @DisplayName("물건 값(Money)을 곱하면 총 얼마인지 Money를 반환한다.")
    void multiply() {
        Count count = new Count(5);
        Money price = new Money(1000);

        Assertions.assertThat(count.multiply(price)).isEqualTo(new Money(5000));
    }

    @Test
    @DisplayName("Count끼리 더할 수 있다.")
    void sum() {
        Count count1 = new Count(5);
        Count count2 = new Count(3);

        Assertions.assertThat(Count.sum(count1, count2)).isEqualTo(new Count(8));
    }

    @Test
    @DisplayName("Count에서 Count를 뺄 수 있다")
    void decreaseBy() {
        Count count = new Count(8);

        Assertions.assertThat(count.decreaseBy(new Count(3))).isEqualTo(new Count(5));
    }

    @Test
    @DisplayName("Count를 1씩 더할 수 있다")
    void increaseOne() {
        Count count = new Count(1);

        Assertions.assertThat(count.increaseOne()).isEqualTo(new Count(2));
    }

    @Test
    @DisplayName("수동 로또 개수가 입력 금액으로 살 수 있는 개수보다 크면 예외를 던진다.")
    void manualCountExceed() {
        Count totalCount = new Count(10);

        Assertions.assertThatThrownBy(() -> totalCount.validateManualCount(11))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 로또 개수는 입력 금액으로 살 수 있는 개수보다 작아야한다.")
    void manualCountNotExceed() {
        Count totalCount = new Count(10);

        Assertions.assertThatNoException()
                .isThrownBy(() -> totalCount.validateManualCount(10));
    }
}

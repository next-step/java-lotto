package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoPublisherTest {

    @Test
    @DisplayName("자동 로또 번호 생성시 1~45 사이의 6숫자가 생성된다")
    void random() {
        RandomLottoPublisher publisher = new RandomLottoPublisher();
        for (int i = 0; i < 100; i++) {
            List<Integer> result = publisher.randomNumber();
            assertThat(result)
                    .hasSize(6)
                    .matches(this::isNumberListSorted)
                    .allMatch(number -> (1 <= number && number <= 45));
        }
    }


    private boolean isNumberListSorted(List<? extends Integer> numbers) {
        boolean result = true;
        for (int i = 0; i < numbers.size() - 1; i++) {
            int current = numbers.get(i);
            int next = numbers.get(i + 1);
            result = Boolean.logicalAnd(result, current < next);
        }
        return result;
    }
}

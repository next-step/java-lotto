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
            List<LottoNumber> result = publisher.get();
            assertThat(result)
                    .hasSize(6)
                    .matches(this::isNumberListSorted)
                    .allMatch(number -> number.smallerThan(LottoNumber.MAX + 1))
                    .allMatch(number -> number.biggerThan(LottoNumber.MIN - 1));
        }
    }


    private boolean isNumberListSorted(List<? extends LottoNumber> numbers) {
        boolean result = true;
        for (int i = 0; i < numbers.size() - 1; i++) {
            LottoNumber current = numbers.get(i);
            LottoNumber next = numbers.get(i + 1);
            result = Boolean.logicalAnd(result, current.smallerThan(next));
        }
        return result;
    }
}

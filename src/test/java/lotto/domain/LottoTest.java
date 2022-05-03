package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    void 생성_테스트() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(1, 3, 5, 6, 7, 8));
    }

    @Test
    void 생성_에러_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(1);
                    numbers.add(3);
                    numbers.add(5);
                    numbers.add(6);
                    numbers.add(7);

                    Lotto lotto = new Lotto(numbers);
                }).withMessageMatching("숫자 6개만 입력 가능합니다");

    }
}

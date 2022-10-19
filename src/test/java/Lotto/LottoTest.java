package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 생성() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    // 어떻게 테스트?
    @Test
    void 유니크한_랜덤_번호로_생성() {}
}

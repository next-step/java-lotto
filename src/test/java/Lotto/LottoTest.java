package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private List<Integer> numbers(int min, int max) {
        return IntStream.range(min, max).boxed().collect(Collectors.toList());
    }

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

    @Test
    void 교집합으로_숫자_추리기() {
        assertThat(new Lotto(numbers(1, 7)).correctCount(new Lotto(numbers(1, 7)))).isEqualTo(6);
    }
}

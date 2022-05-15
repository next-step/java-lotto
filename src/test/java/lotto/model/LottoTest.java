package lotto.model;

import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    List<Integer> integers;
    Number[] numbers;

    @BeforeEach
    void beforeEach() {
        this.integers = IntStream
                .range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        this.numbers = this.integers
                .stream()
                .map(Number::of)
                .toArray(Number[]::new);
    }

    @Test
    @DisplayName("로또 구매 - 자동")
    void auto() {
        assertThat(Lotto.auto().getLotto()).hasSize(6).containsAnyOf(this.numbers);
    }

    @Test
    @DisplayName("로또 구매 - 수동")
    void manual() {
        List<Number> numbers = this.integers.subList(0, 6)
                .stream()
                .map(Number::of)
                .collect(Collectors.toList());

        assertThat(Lotto.manual(numbers).getLotto()).hasSize(6).containsAll(numbers);
    }

    @Test
    @DisplayName("구매한 로또 출력 로직 성능 테스트")
    void performance() {
        long count = 100000;
        String message = "시작 : %s, 종료 : %s, 소요시간 : %s, 크기 : %s";

        // Stream.generate()
        long start = System.currentTimeMillis();
        List<Lotto> lottoList_1 = Stream
                .generate(Lotto::auto)
                .limit(count)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        ResultView.print(String.format(message, start, end, Math.subtractExact(end, start), lottoList_1.size()));

        // IntStream.range()
        start = System.currentTimeMillis();
        List<Lotto> lottoList_2 = LongStream
                .range(0, count)
                .mapToObj(index -> Lotto.auto())
                .collect(Collectors.toList());
        end = System.currentTimeMillis();
        ResultView.print(String.format(message, start, end, Math.subtractExact(end, start), lottoList_2.size()));
    }
}

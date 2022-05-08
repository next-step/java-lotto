package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PrizeTest {

    Map<Integer, Number> numberMap;

    @BeforeEach
    void beforeEach() {
        this.numberMap = IntStream.range(0, 7)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), Number::of));
    }

    @Test
    @DisplayName("Prize 객체 생성 - 랭킹 별 카운드 사이즈")
    void create() {
        assertThat(Prize.counting(Lotto.draw(), Collections.emptyList()).getCountByRank()).hasSize(7);
    }

    @Test
    @DisplayName("로또 등수 별 결과 및 수익률 - 4등부터 1등까지 1개씩 당첨")
    void countByRank_1() {
        Lotto beforeLotto = Lotto.draw(List.of(this.numberMap.get(1), this.numberMap.get(2), this.numberMap.get(3), this.numberMap.get(4), this.numberMap.get(5), this.numberMap.get(6)));
        Lotto first = Lotto.draw(List.of(this.numberMap.get(1), this.numberMap.get(2), this.numberMap.get(3), this.numberMap.get(4), this.numberMap.get(5), this.numberMap.get(6)));
        Lotto second = Lotto.draw(List.of(this.numberMap.get(1), this.numberMap.get(2), this.numberMap.get(3), this.numberMap.get(4), this.numberMap.get(5), this.numberMap.get(0)));
        Lotto third = Lotto.draw(List.of(this.numberMap.get(1), this.numberMap.get(2), this.numberMap.get(3), this.numberMap.get(4), this.numberMap.get(0), this.numberMap.get(0)));
        Lotto fourth = Lotto.draw(List.of(this.numberMap.get(1), this.numberMap.get(2), this.numberMap.get(3), this.numberMap.get(0), this.numberMap.get(0), this.numberMap.get(0)));

        List<Lotto> lottoList = List.of(fourth, third, second, first);

        Prize prize = Prize.counting(beforeLotto, lottoList);

        assertAll(() -> assertThat(prize.getCountByRank()).containsKeys(this.numberMap.get(3), this.numberMap.get(4), this.numberMap.get(5), this.numberMap.get(6)).containsValue(this.numberMap.get(1)),
                () -> assertThat(prize.getWinningRate()).isEqualTo(500388.75));
    }

    @ParameterizedTest(name = "로또 등수 별 결과 - {index}등만 당첨")
    @ValueSource(ints = {6, 5, 4, 3})
    void countByRank_2(int rank) {
        Lotto beforeLotto = Lotto.draw(List.of(this.numberMap.get(1), this.numberMap.get(2), this.numberMap.get(3), this.numberMap.get(4), this.numberMap.get(5), this.numberMap.get(6)));

        List<Number> numbers = IntStream.range(1, 7)
                .mapToObj(index -> {
                    if (index <= rank) return this.numberMap.get(index);
                    return this.numberMap.get(0);
                })
                .collect(Collectors.toList());

        List<Lotto> lottoList = Stream
                .generate(() -> Lotto.draw(numbers))
                .limit(6)
                .collect(Collectors.toList());

        Prize prize = Prize.counting(beforeLotto, lottoList);

        assertAll(() -> assertThat(prize.getCountByRank()).containsKey(this.numberMap.get(rank)).containsValue(this.numberMap.get(6)));
    }
}
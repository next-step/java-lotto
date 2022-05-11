package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    Lotto beforeLotto;

    @BeforeEach
    void beforeEach() {
        this.beforeLotto = Lotto.manual(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "자동 로또 결과 확인 - {index}등")
    @CsvSource(delimiter = '|',
            value = {"1,2,3,4,5,6|FIRST",
                    "1,2,3,4,5,0|SECOND",
                    "1,2,3,4,0,0|THIRD",
                    "1,2,3,0,0,0|FORTH",
                    "0,0,0,0,0,0|MISS"})
    void classify(String value, String stringRank) {
        List<Integer> numbers = Arrays
                .stream(value.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Rank rank = Rank.valueOf(stringRank);
        List<Lotto> lottoList = List.of(Lotto.manual(numbers));
        Prize prize = Prize.init(this.beforeLotto).classify(lottoList);

        assertThat(prize.getRanks()).containsKeys(rank).containsValue(Number.of(1L));
    }

    @Test
    @DisplayName("자동 로또 보너스 결과 확인")
    void classify() {
        Lotto third = Lotto.manual(List.of(1, 2, 3, 4, 5, 0));
        List<Lotto> lottoList = List.of(third);
        Prize prize = Prize.init(this.beforeLotto, Number.of()).classify(lottoList);

        assertThat(prize.getRanks()).containsKeys(SECOND).containsValue(Number.of(1L));
    }
}

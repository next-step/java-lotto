package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    Lotto beforeLotto;

    @BeforeEach
    void beforeEach() {
        this.beforeLotto = Lotto.manual(List.of(
                Number.of(1L),
                Number.of(2L),
                Number.of(3L),
                Number.of(4L),
                Number.of(5L),
                Number.of(6L)));
    }

    @ParameterizedTest(name = "자동 로또 결과 확인 - {index}등")
    @CsvSource(delimiter = '|',
            value = {"1,2,3,4,5,6|FIRST",
                    "1,2,3,4,5,0|SECOND",
                    "1,2,3,4,0,0|FORTH",
                    "1,2,3,0,0,0|FIFTH",
                    "0,0,0,0,0,0|MISS"})
    void classify(String value, String stringRank) {
        List<Number> numbers = Arrays
                .stream(value.split(","))
                .map(Number::of)
                .collect(Collectors.toList());

        Rank rank = Rank.valueOf(stringRank);
        Lotto lotto = Lotto.manual(numbers);
        List<Lotto> lottoList = List.of(lotto);
        Prize prize = Prize.init(this.beforeLotto).classify(lottoList);

        assertThat(rank.getTotalCorrectCount(prize.getRanks())).isEqualTo(Number.of(1L));
    }

    @Test
    @DisplayName("자동 로또 보너스 결과 확인")
    void classify() {
        Lotto third = Lotto.manual(List.of(
                Number.of(1L),
                Number.of(2L),
                Number.of(3L),
                Number.of(4L),
                Number.of(0L),
                Number.of(7L)));
        List<Lotto> lottoList = List.of(third);
        Prize prize = Prize.init(this.beforeLotto, Number.of(7L)).classify(lottoList);

        assertThat(THIRD.getTotalCorrectCount(prize.getRanks())).isEqualTo(Number.of(1L));
    }
}

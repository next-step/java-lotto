package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("모두 일치")
    @Test
    void matchNumbersCountsAllMatchTest() {
        List<Integer> numbers =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toList());


        List<Integer> winnerNumbers =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toList());

        Lotto lotto = new Lotto(new LottoFixedLottoNumberGenerator(numbers));
        Lotto winnerLotto = new Lotto(new LottoFixedLottoNumberGenerator(winnerNumbers));

        assertEquals(lotto.matchNumberCounts(winnerLotto), 6);
    }

    @DisplayName("모두 일치하지 않음")
    @Test
    void matchNumbersCountsTest() {
        List<Integer> numbers =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toList());

        List<Integer> winnerNumbers =
                Stream.of(11, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        Lotto lotto = new Lotto(new LottoFixedLottoNumberGenerator(numbers));
        Lotto winnerLotto = new Lotto(new LottoFixedLottoNumberGenerator(winnerNumbers));

        assertEquals(lotto.matchNumberCounts(winnerLotto), 0);
    }

}
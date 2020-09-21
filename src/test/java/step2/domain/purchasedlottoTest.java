package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class purchasedlottoTest {

    purchasedlotto purChasedLotto;
    WinningLotto winningLotto;

    @BeforeEach
    void init() {
        List<Lotto> lottoList = Stream.of(Lotto.create("1, 2, 3, 4, 5, 6"), Lotto.create("1, 2, 3, 12, 30, 40"))
                .collect(Collectors.toList());
        winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6", "45");
        purChasedLotto = new purchasedlotto(lottoList);
    }

    @Test
    @DisplayName("총 로또 상금 테스트")
    void getTotalPrize() {
        purChasedLotto.matchNumber(winningLotto);
        assertEquals(purChasedLotto.getTotalPrize(), 2_000_005_000);
    }
}
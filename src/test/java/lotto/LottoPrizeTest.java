package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoPrize.*;
import static org.junit.jupiter.api.Assertions.*;


class LottoPrizeTest {


    @DisplayName("3개가 맞는 로또 갯수를 구한다.")
    @Test
    void FourthPrize() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        Lotto prizeLotto = Lotto.create(() -> List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> targetLottoList = List.of(Lotto.create(() -> List.of(1, 2, 3, 8, 9, 10)),
                Lotto.create(() -> List.of(1, 2, 3, 10, 11, 12)),
                Lotto.create(() -> List.of(12, 13, 4, 5, 6, 7)));

        Assertions.assertThat(FOURTH.getMatchCount(prizeLotto, targetLottoList)).isEqualTo(3);
    }
}

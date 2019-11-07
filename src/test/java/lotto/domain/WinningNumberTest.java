package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    void 당첨조회_객체_생성() {
        Integer[] number = {1,2,3,4,5,6};
        List<Integer> winningNumbers = Arrays.asList(number);
        WinningNumber checkWinningNumber = new WinningNumber(winningNumbers);
        assertThat(checkWinningNumber).isEqualTo(new WinningNumber(winningNumbers));
    }

    @Test
    void 당첨조회() {
        Integer[] number = {1,2,3,4,5,6};
        List<Integer> winningNumbers = Arrays.asList(number);
        List<Lotto> purchasedLotto = Arrays.asList(new Lotto(1,2,3,4,5,6));
        purchasedLotto.forEach(lotto -> {
            assertThat(LottoWinningAmount.findWinningAmount(lotto.matchLottoNumberCount(winningNumbers))).isEqualTo(LottoWinningAmount.FIRST);
        });
    }
}
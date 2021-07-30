package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class winningStatisticsServiceTest {


    @DisplayName("로또번호와 당첨번호를 비교해서 일치한 개수를 반환")
    @Test
    void test() {
        WinningNumbers winningNumbers = new WinningNumbers("1,3,5,7,10,15");
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto())

    }

}
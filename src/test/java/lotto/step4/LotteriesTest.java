package lotto.step4;

import lotto.step4.domain.LottoNumber;
import lotto.step4.domain.Lotteries;
import lotto.step4.domain.Lottery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LotteriesTest {

    @Test
    @DisplayName("자동 로또 10개와 수동 로또2개를 구입하면 총 12장의 로또를 가진다.")
   void createLotteries() {
        Lottery lottery = new Lottery(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lottery lottery2 = new Lottery(Arrays.asList(new LottoNumber(11), new LottoNumber(21), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)));
        Lotteries lotteries = new Lotteries(10, new ArrayList<>(Arrays.asList(lottery, lottery2)));
        Assertions.assertThat(lotteries.getLotteries().size()).isEqualTo(12);
    }
}

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
        Lottery lottery = new Lottery(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        Lottery lottery2 = new Lottery(Arrays.asList(LottoNumber.of(11), LottoNumber.of(21), LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16)));
        Lotteries lotteries = new Lotteries(10, new ArrayList<>(Arrays.asList(lottery, lottery2)));
        Assertions.assertThat(lotteries.values().size()).isEqualTo(12);
    }
}

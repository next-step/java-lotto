package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("6개부터 1개까지 매칭된 총 상금을 구한다.")
    @Test
    void total_price() {

        final WinningLotto 우승로또 = WinningLotto.from("1, 2, 3, 4, 5, 6", "45");
        final Lotto 여섯개일치로또 = Lotto.from("1, 2, 3, 4, 5, 6");
        final Lotto 다섯개보너스일치로또 = Lotto.from("1, 2, 3, 4, 5, 45");
        final Lotto 다섯개일치로또 = Lotto.from("1, 2, 3, 4, 5, 7");
        final Lotto 네개일치로또 = Lotto.from("1, 2, 3, 4, 7, 8");
        final Lotto 세개일치로또 = Lotto.from("1, 2, 3, 7, 8, 9");
        final Lotto 두개일치로또 = Lotto.from("1, 2, 7, 8, 9, 10");
        final Lotto 한개일치로또 = Lotto.from("1, 7, 8, 9, 10, 11");

        final List<WinningPrize> resultList = List.of(
                WinningPrize.of(우승로또, 여섯개일치로또)
                , WinningPrize.of(우승로또, 다섯개보너스일치로또)
                , WinningPrize.of(우승로또, 다섯개일치로또)
                , WinningPrize.of(우승로또, 네개일치로또)
                , WinningPrize.of(우승로또, 세개일치로또)
                , WinningPrize.of(우승로또, 두개일치로또)
                , WinningPrize.of(우승로또, 한개일치로또));
        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(resultList);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(2_031_555_000));
    }

    @DisplayName("2등과 3등(5개 매치, 보너스 매치 여부) 우승 상금을 구한다.")
    @Test
    void match_price() {

        final WinningLotto 우승로또 = WinningLotto.from("1, 2, 3, 4, 5, 6", "45");
        final Lotto 다섯개일치로또1 = Lotto.from("1, 2, 3, 4, 5, 45");
        final Lotto 다섯개일치로또2 = Lotto.from("1, 2, 3, 4, 5, 7");

        final List<WinningPrize> resultList = List.of(
                WinningPrize.of(우승로또, 다섯개일치로또1)
                , WinningPrize.of(우승로또, 다섯개일치로또2));
        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(resultList);

        assertThat(winningResult.sum()).isEqualTo(new BigDecimal(31_500_000));
    }
}

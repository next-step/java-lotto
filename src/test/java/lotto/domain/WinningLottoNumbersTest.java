package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {
    @Test
    void getResult_로또_여러_장의_당첨_결과를_생성한다() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoNumbers firstNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers secondNumbers = new LottoNumbers(1, 2, 3, 4, 5, 7);
        LottoNumbers thirdNumbers = new LottoNumbers(1, 2, 3, 4, 5, 8);
        LottoNumbers fourthNumbers = new LottoNumbers(1, 2, 3, 4, 8, 9);
        LottoNumbers fifthNumbers = new LottoNumbers(1, 2, 3, 8, 9, 10);
        LottoNumbers noPrizeNumbers = new LottoNumbers(1, 2, 8, 9, 10, 11);

        Map<LottoCashPrize, Integer> results = winningLottoNumbers.getResult(
                        List.of(firstNumbers, secondNumbers, thirdNumbers, fourthNumbers, fifthNumbers, noPrizeNumbers))
                .getValue();

        assertThat(results.get(LottoCashPrize.valueOf("FIRST"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("SECOND"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("THIRD"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("FOURTH"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("FIFTH"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("NO_PRIZE"))).isEqualTo(1);
    }

    @Test
    void getResult_2등을_제외한_나머지_등수는_보너스_번호_일치하더라도_같은_결과를_반환한다() {
        int bounsNumber = 7;

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6), bounsNumber);
        LottoNumbers firstNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers secondNumbers = new LottoNumbers(1, 2, 3, 4, 5, bounsNumber);
        LottoNumbers thirdNumbers = new LottoNumbers(1, 2, 3, 4, 5, 8);
        LottoNumbers fourthNumbers = new LottoNumbers(1, 2, 3, 4, 8, bounsNumber);
        LottoNumbers fifthNumbers = new LottoNumbers(1, 2, 3, 8, 9, bounsNumber);
        LottoNumbers noPrizeNumbers = new LottoNumbers(1, 2, 8, 9, 10, bounsNumber);

        Map<LottoCashPrize, Integer> results = winningLottoNumbers.getResult(
                        List.of(firstNumbers, secondNumbers, thirdNumbers, fourthNumbers, fifthNumbers, noPrizeNumbers))
                .getValue();

        assertThat(results.get(LottoCashPrize.valueOf("FIRST"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("SECOND"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("THIRD"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("FOURTH"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("FIFTH"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("NO_PRIZE"))).isEqualTo(1);
    }
}

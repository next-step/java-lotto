package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {
    @ParameterizedTest
    @CsvSource(value = {
            "7,8,9,11,12,13=MISS",
            "1,8,9,11,12,13=MISS",
            "1,2,9,11,12,13=MISS",
            "1,2,3,11,12,13=FIFTH",
            "1,2,3,10,12,13=FOURTH",
            "1,2,3,10,20,13=THIRD",
            "1,2,3,10,20,30=FIRST",
    }, delimiter = '=')
    @DisplayName("당첨번호와 로또번호가 0개에서 6개까지 일치한다.")
    void winningLottoMatch(String lottoNumber, Rank rank) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(List.of(new LottoNumber(Arrays.asList(1, 2, 3, 10, 20, 30))));
        LottoWinning lottoWinning = new LottoWinning(lottoNumber, new Lotto("1000", new LottoNumbers(lottoNumbers)));
        assertThat(lottoWinning.getWinningCount(rank)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또를 14,000원 구매하고 5등이 2개면 수익율은 0.35 이다")
    void returnRate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new LottoNumber(Arrays.asList(33, 34, 45, 11, 22, 19))));
        LottoWinning lottoWinning = new LottoWinning("1,2,3,4,5,6", new Lotto("14000", new LottoNumbers(lottoNumbers)));

        String returnRate = lottoWinning.getReturnRate();
        System.out.println(lottoWinning.getWinningCount(Rank.FIFTH));
        assertThat(returnRate).isEqualTo("0.35");


    }
}

package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    LottoResult lottoResult;
    List<LottoNumbers> purchasedLottoNumbers;
    LottoNumbers lastWeekLottoNumbers;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        LottoNumber one = new LottoNumber(1);
        LottoNumber three = new LottoNumber(3);
        LottoNumber five = new LottoNumber(5);
        LottoNumber seven = new LottoNumber(7);
        LottoNumber eight = new LottoNumber(8);
        LottoNumber nine = new LottoNumber(9);
        LottoNumber twelve = new LottoNumber(12);
        LottoNumber twentyOne = new LottoNumber(21);
        LottoNumber twentyTwo = new LottoNumber(22);
        LottoNumber thirtyTwo = new LottoNumber(32);
        LottoNumber fortyFive = new LottoNumber(45);


        purchasedLottoNumbers = List.of(
                new LottoNumbers(List.of(one, three, five, seven, nine, twentyTwo)),
                new LottoNumbers(List.of(one, three, eight, twentyTwo, twentyOne, thirtyTwo)),
                new LottoNumbers(List.of(one, three, five, twelve, nine, twentyOne))
        );

        lastWeekLottoNumbers = new LottoNumbers(List.of(one, three, eight, twelve, twentyTwo, fortyFive));
    }

    @Test
    @DisplayName("4개 맞은 사람이 1명, 3개맞은 사람이 2명인지 확인")
    void 로또_결과_테스트() {
        lottoResult.calculateLottoResult(purchasedLottoNumbers, lastWeekLottoNumbers, 3000);
        Map<Integer, Integer> lottoRankings = lottoResult.getLottoRankings();
        assertThat(lottoRankings.get(4)).isEqualTo(1);
        assertThat(lottoRankings.get(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("복권 수익/구입금액 확인")
    void 로또_수익률_테스트() {
        lottoResult.calculateLottoResult(purchasedLottoNumbers, lastWeekLottoNumbers, 3000);
        assertThat(lottoResult.getPercentage()).isEqualTo(20.0);
    }
}
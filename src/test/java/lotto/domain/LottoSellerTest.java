package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoSellerTest {

    private LottoSeller lottoSeller = new LottoSeller();

    @DisplayName("로또를 한개이상 구입할수있다.")
    @ParameterizedTest
    @CsvSource(value = {
        "1000,1",
        "2000,2",
        "3000,3"
    })
    void buy_many_lotto(long price, int count) {
        LottoPaper lottoPaper = lottoSeller.sell(price);

        assertThat(lottoPaper.getCount()).isEqualTo(count);
    }


    @DisplayName("수동으로 로또 번호 구매할수 있다.")
    @Test
    @MethodSource("")
    void buy_manual_lotto(){
        LottoNums firstLottoNums = LottoNums.of(Arrays.asList(1,2,3,4,5,6));
        LottoNums secondLottoNums = LottoNums.of(Arrays.asList(1,2,3,4,5,7));

        long price = 2000;
        LottoPaper lottoPaper = lottoSeller.sell(price, Arrays.asList(firstLottoNums, secondLottoNums));

        LottoMatchResult lottoMatchResult = lottoPaper.getResult(firstLottoNums, new LottoNum(7), 1000);
        assertThat(lottoMatchResult.get(Rank.FIRST)).isEqualTo(1L);
        assertThat(lottoMatchResult.get(Rank.SECOND)).isEqualTo(1L);
    }
}

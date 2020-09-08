package lotto.domain;

import lotto.common.LottoPriceInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchResultTest {

    @DisplayName("LottoMatch 결과 저장 객체 생성")
    @Test
    void newInstance() {
        //given
        List<LottoPriceInfo> lottoPriceInfos = Arrays.asList(LottoPriceInfo.LOTTO_RANK_4, LottoPriceInfo.LOTTO_RANK_3);
        int money = 3_000;

        //when
        LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoPriceInfos, money);

        //then
        long totalPrice = lottoPriceInfos.stream()
                .mapToLong(LottoPriceInfo::getPrice)
                .sum();

        double expected = Math.ceil(totalPrice * 100.0 / money) / 100.0;
        assertThat(lottoMatchResult.getProfit()).isEqualTo(expected);
    }
}
package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @CsvSource({
            "LAST_PLACE,10,0",
            "FIRST_PLACE,100,200000000000",
            "SECOND_PLACE,10,300000000",
            "THREE_PLACE,10,15000000",
            "FOUR_PLACE,10,500000",
            "FIVE_PLACE,10,50000"
    })
    @ParameterizedTest
    void prizeAmountTest(String enumName, int lottoSize, long expertMoneyValue) {
        LottoRank lottoRank = LottoRank.valueOf(enumName);
        Money prizeAmount = lottoRank.prizeAmount(lottoSize);

        assertThat(prizeAmount)
                .isEqualTo(expertMoneyValue);
    }

    @CsvSource({
            "0,false,LAST_PLACE",
            "1,false,LAST_PLACE",
            "2,false,LAST_PLACE",
            "3,false,FIVE_PLACE",
            "4,false,FOUR_PLACE",
            "5,false,THREE_PLACE",
            "5,true,SECOND_PLACE",
            "6,false,FIRST_PLACE"
    })
    @ParameterizedTest
    void ofTest(int matchesCount, boolean bonusNumber, String expertEnumName) {
        LottoRank expertLottoRank = LottoRank.valueOf(expertEnumName);

        assertThat(LottoRank.of(matchesCount, bonusNumber))
                .isEqualTo(expertLottoRank);
    }
}
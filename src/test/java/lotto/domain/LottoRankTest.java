package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @CsvSource({
            "LAST_PLACE,10,0",
            "FIRST_PLACE,10,20000000000",
            "SECOND_PLACE,10,15000000",
            "THREE_PLACE,10,500000",
            "FOUR_PLACE,10,50000",
    })
    @ParameterizedTest
    void prizeAmountTest(String enumName, int lottoSize, long expertMoneyValue) {
        LottoRank lottoRank = LottoRank.valueOf(enumName);
        Money prizeAmount = lottoRank.prizeAmount(lottoSize);

        assertThat(prizeAmount)
                .isEqualTo(expertMoneyValue);
    }

    @CsvSource({
            "1,LAST_PLACE",
            "2,LAST_PLACE",
            "3,FOUR_PLACE",
            "4,THREE_PLACE",
            "5,SECOND_PLACE",
            "6,FIRST_PLACE"
    })
    @ParameterizedTest
    void ofTest(int matchesCount, String expertEnumName) {
        LottoRank expertLottoRank = LottoRank.valueOf(expertEnumName);

        assertThat(LottoRank.of(matchesCount))
                .isEqualTo(expertLottoRank);
    }
}
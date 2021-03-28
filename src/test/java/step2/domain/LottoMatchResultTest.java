package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LottoMatchResultTest {

    @DisplayName("메세지를 정상적으로 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void resultMessageTest(int value, int matchedPrice) {
        Map<Integer, Long> matchResult = Collections.singletonMap(value, 1L);
        LottoMatchResult lottoMatchResult =
                new LottoMatchResult(1000, matchResult);

        List<String> messages = lottoMatchResult.resultMessages();
        String expectedMessage = value + "개 일치 (" + matchedPrice + "원)-1개";

        assertTrue(messages.contains(expectedMessage));
    }

    @DisplayName("이익을 정확하게 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"3:5000:5.0", "4:50000:50.0", "5:1500000:1500.0", "6:2000000000:2000000.0"},
            delimiter = ':')
    void resultBenefitMessage(int value, Long matchedPrice, double expectedBenefit) {
        Map<Integer, Long> matchResult = Collections.singletonMap(value, 1L);
        LottoMatchResult lottoMatchResult =
                new LottoMatchResult(1000, matchResult);

        double benefit = lottoMatchResult.resultBenefit();
        System.out.println("benefit = " + benefit);

        assertEquals(benefit, expectedBenefit);
    }

    @Test
    void getGainOrLossTest() {

    }

}
package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoAnswerTest {
    @DisplayName("보너스 번호가 정답 정보와 겹치는 경우 예외를 잘 발생하는지 확인")
    @Test
    void answerIncludeBonusNumber() {
        assertThrows(RuntimeException.class, () -> {
            new LottoAnswer(
                new LottoTicket(
                    new ArrayList<LottoNumber>() {{
                        add(new LottoNumber(1));
                        add(new LottoNumber(2));
                        add(new LottoNumber(3));
                        add(new LottoNumber(4));
                        add(new LottoNumber(5));
                        add(new LottoNumber(6));
                    }}
                ),
                new LottoNumber(6)
            );
        });
    }

    private static Stream<Arguments> providerCalculateScoreParams() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 6", LottoScore.FIRST),
            Arguments.of("1, 2, 3, 4, 5, 7", LottoScore.SECOND),
            Arguments.of("1, 2, 3, 4, 5, 8", LottoScore.THIRD),
            Arguments.of("1, 2, 3, 4, 7, 8", LottoScore.FOURTH),
            Arguments.of("1, 2, 3, 4, 8, 9", LottoScore.FOURTH),
            Arguments.of("1, 2, 3, 7, 8, 9", LottoScore.FIFTH),
            Arguments.of("1, 2, 3, 8, 9, 10", LottoScore.FIFTH),
            Arguments.of("1, 2, 7, 8, 9, 10", LottoScore.NOTHING)
        );
    }

    @DisplayName("정답과 티켓의 정보에 따라서 스코어를 잘 계산하는지 확인")
    @ParameterizedTest
    @MethodSource("providerCalculateScoreParams")
    void calculateScore(String manualNumbers, LottoScore score) {
        LottoAnswer answer = new LottoAnswer(
            new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                    add(new LottoNumber(2));
                    add(new LottoNumber(3));
                    add(new LottoNumber(4));
                    add(new LottoNumber(5));
                    add(new LottoNumber(6));
                }}
            ),
            new LottoNumber(7)
        );
        LottoTicket ticket = LottoTicketGenerator.generateManualTicket(manualNumbers);

        assertEquals(answer.calculateScore(ticket), score);
    }
}
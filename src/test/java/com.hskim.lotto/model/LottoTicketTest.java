package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {

    @DisplayName("LottoTicket 생성 성공 테스트")
    @Test
    void create_성공() {
        // given
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(23, 9, 17, 8, 1, 39));

        // when & then
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(23, 9, 17, 8, 1, 39)));
    }

    @DisplayName("LottoTicket 생성 실패 (지정된 갯수와 다름) 테스트")
    @Test
    void create_갯수다름_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTicket(Arrays.asList(23, 17));
        }).withMessage(LottoExceptionMessage.INVALID_NUMBER_SIZE.getMessage());
    }


    @DisplayName("LottoTicket 생성 실패 (중복 숫자) 테스트")
    @Test
    void create_중복_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTicket(Arrays.asList(23, 23, 17, 8, 1, 39));
        }).withMessage(LottoExceptionMessage.DUPLICATED_NUMBER.getMessage());
    }

    @DisplayName("getWinningCondition() 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoTicketAndCondition")
    void getWinningCondition(LottoTicket lottoTicket, WinningCondition expected) {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 8, 9, 10, 17, 25);

        // when
        WinningCondition result = lottoTicket.getWinningCondition(
                LottoNumber.convertToLottoNumberList(winningNumbers));

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoTicketAndCondition() {
        return Stream.of(
                Arguments.of(new LottoTicket(Arrays.asList(1, 8, 9, 10, 17, 25)),
                        new WinningCondition(6)),
                Arguments.of(new LottoTicket(Arrays.asList(1, 8, 9, 10, 17, 24)),
                        new WinningCondition(5)),
                Arguments.of(new LottoTicket(Arrays.asList(1, 8, 9, 10, 16, 24)),
                        new WinningCondition(4)),
                Arguments.of(new LottoTicket(Arrays.asList(1, 8, 9, 11, 16, 24)),
                        new WinningCondition(3))
        );
    }
}

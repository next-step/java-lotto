package lottogame.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lottogame.domain.enums.LottoGameRank;
import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.LottoResult;
import lottogame.domain.lotto.LottoTicket;

class TicketMachineTest {
    @Test
    @DisplayName("로또 숫자들을 받았을 때 정상적으로 티켓을 생성한다.")
    void createTicket() {
        LottoTicket lottoTicket = new TicketMachine().createLottoTicket(() -> createLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(createLottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "로또 추첨 결과가 주어졌을 때, 티켓에 해당하는 순위를 찾는다: {1}")
    @MethodSource("provideLottoResult")
    void verifyRank(LottoResult lottoResult, LottoGameRank expectedRank) {
        TicketMachine ticketMachine = new TicketMachine();
        LottoTicket lottoTicket = ticketMachine.createLottoTicket(() -> createLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(ticketMachine.verifyRank(lottoTicket, lottoResult)).isEqualTo(expectedRank);
    }

    private static List<LottoNumber> createLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
            .mapToObj(LottoNumber::new)
            .collect(toList());
    }

    private static Stream<Arguments> provideLottoResult() {
        return Stream.of(
            Arguments.of(new LottoResult(List.of(1, 2, 3, 4, 5, 6), 1), LottoGameRank.FIRST),
            Arguments.of(new LottoResult(List.of(1, 2, 3, 4, 5, 7), 1), LottoGameRank.THIRD),
            Arguments.of(new LottoResult(List.of(1, 2, 3, 4, 7, 8), 1), LottoGameRank.FOURTH),
            Arguments.of(new LottoResult(List.of(1, 2, 3, 7, 8, 9), 1), LottoGameRank.FIFTH),
            Arguments.of(new LottoResult(List.of(1, 2, 7, 8, 9, 10), 1), LottoGameRank.NONE)
        );
    }
}

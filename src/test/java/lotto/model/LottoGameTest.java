package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("로또 시작 테스트")
    @ParameterizedTest
    @MethodSource("ticketList")
    void 로또_게임_시작(int[] intArr) {
        List<LottoNumber> ticketNumber = Arrays.stream(intArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoTicket ticket = new LottoTicket(ticketNumber);
        List<LottoTicket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        LottoTickets lottoTickets = new LottoTickets(ticketList);

        int[] winNumberArr = {1, 2, 3, 4, 5, 6};
        List<LottoNumber> winNumber = Arrays.stream(winNumberArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningTicket winTicket = new WinningTicket(new LottoTicket(winNumber), new LottoNumber(7));

        LottoGame lottoGame = new LottoGame(lottoTickets, winTicket);
        LottoResult lottoResult = lottoGame.playLotto();
        long totalReward = lottoResult.getTotalReward();

        Assertions.assertThat((int) totalReward).isEqualTo(Rank.FIRST.prize());
    }

    private static Stream<Arguments> ticketList() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};

        return Stream.of(
                Arguments.of(arr1)
        );
    }

}

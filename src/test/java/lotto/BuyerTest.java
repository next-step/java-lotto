package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {
    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(new LottoTicket(List.of(new LottoNumbers(11, 12, 13, 14, 15, 16))),Rank.NO_RANK),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1, 12, 13, 14, 15, 16))),Rank.NO_RANK),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1, 2, 13, 14, 15, 16))),Rank.NO_RANK),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1, 2, 3, 14, 15, 16))),Rank.FIFTH),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1, 2, 3, 4, 15, 16))),Rank.FOURTH),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1, 2, 3, 4, 5, 16))),Rank.THIRD),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1,2,3,4,5,6))),Rank.SECOND),
                Arguments.of(new LottoTicket(List.of(new LottoNumbers(1,2,3,4,5,8))),Rank.FIRST)
        );
    }

    @Test
    void 구매금액에맞게_로또가_구입되는지확인() {
        int money = 15500;
        Buyer buyer = new Buyer();
        buyer.purchaseLottoTicket(money, 0);
        assertThat(buyer.purchasedLottoTicket.getLottoTicket().size()).isEqualTo(15);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 당첨된결과가_정확한지테스트(LottoTicket purchasedNumber, Rank rank) {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,8", 6);
        Buyer buyer = new Buyer();

        buyer.checkLottoWinningNumbers(purchasedNumber, winningNumbers);

        HashMap<Rank, Integer> result = buyer.lottoResult;
        assertThat(result.containsKey(rank)).isTrue();
    }
}

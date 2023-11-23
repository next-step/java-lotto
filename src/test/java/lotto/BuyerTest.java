package lotto;

import lotto.domain.*;
import lotto.view.ResultView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(List.of(new LottoNumber(Arrays.asList(11, 12, 13, 14, 15, 16))), Rank.NO_RANK),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 12, 13, 14, 15, 16))), Rank.NO_RANK),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 2, 13, 14, 15, 16))), Rank.NO_RANK),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 2, 3, 14, 15, 16))), Rank.FIFTH),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 2, 3, 4, 15, 16))), Rank.FOURTH),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 16))), Rank.THIRD),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))), Rank.SECOND),
                Arguments.of(List.of(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8))), Rank.FIRST));
    }

    @Test
    void 구매금액에맞게_로또가_구입되는지확인() {
        int money = 15500;
        Buyer buyer = new Buyer();
        buyer.purchaseLotto(money);
        assertThat(Buyer.purchasedLottoNumbers.size()).isEqualTo(15);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 당첨된결과가_정확한지테스트(List<LottoNumber> purchasedNumber, Rank rank) {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,8", 6);
        Buyer buyer = new Buyer();

        Buyer.purchasedLottoNumbers.addAll(purchasedNumber);
        buyer.checkLottoWinningNumbers(buyer, winningNumbers);
        
        HashMap<Rank, Integer> result = buyer.lottoResult;
        assertThat(result.containsKey(rank)).isTrue();
    }
}

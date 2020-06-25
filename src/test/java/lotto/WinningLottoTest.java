package lotto;

import lotto.domain.*;
import lotto.util.ListConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    private final List<LottoNumber> lottoNumbersOneToSix = ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,6");

    @Test
    @DisplayName("계산한 Rank의 리스트가 실제 구매 티켓과 담청 티켓의 매칭 결과와 일치하는 지 테스트")
    void IsRankEqualWithMatchingOfBuyingTicketAndWinningTicket() {
        CustomLottoTicket winningLottoTicket = new CustomLottoTicket(lottoNumbersOneToSix);
        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, new LottoNumber(20));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new CustomLottoTicket(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,6")));
        lottoTickets.add(new CustomLottoTicket(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,7,8")));
        lottoTickets.add(new CustomLottoTicket(ListConverter.convertCommaStringToLottoNumbers("11,12,13,14,15,16")));

        List<Rank> actual = winningLotto.getLottoRank(lottoTickets);
        List<Rank> expected = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.FOURTH, Rank.MISS));

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }

    @ParameterizedTest
    @DisplayName("보너스 번호의 숫자가 중복 될 경우 Fail")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void FailIfBonusNumberDuplicateWithWinningNumbers(int input) {
        CustomLottoTicket lottoTicket = new CustomLottoTicket(lottoNumbersOneToSix);

        assertThatThrownBy(() -> new WinningLotto(lottoTicket, new LottoNumber(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

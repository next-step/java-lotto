package lotto.domain.lotto;

import lotto.domain.prize.Rank;
import lotto.domain.prize.WinningResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoTicket.create(1)).doesNotThrowAnyException();
    }

    @Test
    void 구입_장수만큼_로또번호를_생성한다() {
        int quantity = 5;
        LottoTicket lottoTicket = LottoTicket.create(quantity);

        assertThatCode(() -> lottoTicket.tellLottoNumbers(quantity - 1)).doesNotThrowAnyException();
        assertThatThrownBy(() -> lottoTicket.tellLottoNumbers(quantity)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 구입_장수가_0이하인경우(int quantity) {
        assertThatThrownBy(() -> LottoTicket.create(quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨결과를_생성한다() {
        String enteredWinNumber = "1, 11, 17, 23, 31, 43";
        LottoTicket lottoTicket = LottoTicket.create(1);
        int enteredBonusBall = 7;
        assertThatCode(() -> {
            lottoTicket.makeWinningResult(enteredWinNumber, enteredBonusBall);
        }).doesNotThrowAnyException();
    }

    @Test
    void 당첨통계를_만든다() {
        List<LottoNumber> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(k -> LottoNumber.create(k)).collect(Collectors.toList());
        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);
        LottoTicket lottoTicket = LottoTicket.createOne(Arrays.asList(lottoNumbers));

        String enteredWinNumber = "1, 2, 3, 4, 5, 7";
        int enteredBonusBall = 6;

        WinningResult winningResult = lottoTicket.makeWinningResult(enteredWinNumber, enteredBonusBall);

        assertThat(winningResult.tellWinningCount(Rank.FIRST)).isEqualTo(0);
        assertThat(winningResult.tellWinningCount(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.tellWinningCount(Rank.MISS)).isEqualTo(0);
    }
}
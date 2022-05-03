package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static lotto.domain.LottoNumbers.generateLottoNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {
    @Test
    void lottoResult는_lottoNumbers_없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoResult(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1:5", "1:7"}, delimiter = ':')
    void lottoResult는_올바르지_않은_개수로_생성시_예외를_발생시킨다(int from, int to) {
        assertThatThrownBy(() -> {
            new LottoResult(generateLottoNumbers(from, to));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check는_당첨_정보_목록를_반환한다() {
        LottoResult lottoResult = new LottoResult(generateLottoNumbers(1, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(generateLottoNumbers(1, 6)),
                new LottoTicket(generateLottoNumbers(2, 7)),
                new LottoTicket(generateLottoNumbers(3, 8)),
                new LottoTicket(generateLottoNumbers(4, 9)),
                new LottoTicket(generateLottoNumbers(5, 10)))
        );

        LottoPrizes lottoPrizes = new LottoPrizes(List.of(
                LottoPrize.FIRST,
                LottoPrize.SECOND,
                LottoPrize.THIRD,
                LottoPrize.FOURTH,
                LottoPrize.NONE
        ));

        assertEquals(lottoResult.check(lottoTickets).getLottoPrizes(), lottoPrizes.getLottoPrizes());
    }

}

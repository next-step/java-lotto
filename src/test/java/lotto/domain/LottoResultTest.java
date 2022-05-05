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
            new LottoResult(null, new LottoNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoResult는_bonusNumber_없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoResult(new LottoNumbers(List.of(new LottoNumber(1))), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoResult는_lottoNumbers와_bonusNumber가_중복되면_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoResult(new LottoNumbers(List.of(new LottoNumber(1))), new LottoNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1:5", "1:7"}, delimiter = ':')
    void lottoResult는_올바르지_않은_개수로_생성시_예외를_발생시킨다(int from, int to) {
        assertThatThrownBy(() -> {
            new LottoResult(generateLottoNumbers(from, to), new LottoNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check는_당첨_정보_목록를_반환한다() {
        LottoResult lottoResult = new LottoResult(generateLottoNumbers(2, 7), new LottoNumber(1));
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(generateLottoNumbers(2, 7)),
                new LottoTicket(generateLottoNumbers(1, 6)),
                new LottoTicket(generateLottoNumbers(3, 8)),
                new LottoTicket(generateLottoNumbers(4, 9)),
                new LottoTicket(generateLottoNumbers(5, 10)),
                new LottoTicket(generateLottoNumbers(6, 11)))
        );

        LottoPrizes lottoPrizes = new LottoPrizes(List.of(
                LottoPrize.FIRST,
                LottoPrize.SECOND,
                LottoPrize.THIRD,
                LottoPrize.FOURTH,
                LottoPrize.FIFTH,
                LottoPrize.NONE
        ));

        assertEquals(lottoPrizes.getLottoPrizes(), lottoResult.check(lottoTickets).getLottoPrizes());
    }

}

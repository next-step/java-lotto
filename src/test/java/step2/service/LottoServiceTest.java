package step2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.AutoNumberGenerator;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;
import step2.utils.LottoNumberGenerator;
import step2.utils.PassiveNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoServiceTest {

    @Test
    @DisplayName("번호 다맞췄을때 1등으로 저장되는지 테스트")
    void calculateNumberOfMatchToWinningNumbers() {
        // given
        int numberOfLottoTickets = 1;

        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoNumberGenerator lottoNumberGenerator = new PassiveNumberGenerator(lottoNumbers);
        LottoTickets lottoTickets = new LottoTickets(numberOfLottoTickets, lottoNumberGenerator);

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);

        LottoService lottoService = new LottoService();
        PrizeMoney prizeMoney = new PrizeMoney();
        ResultDto resultDto = new ResultDto();

        // when
        lottoService.calculateNumberOfMatchToWinningNumbers(lottoTickets.getLottoTickets(), winningNumbers,
                prizeMoney, resultDto);

        // then
        Map<Integer, Integer> matchCount = resultDto.getMatchCount();
        int expected = 1;
        int actual = matchCount.get(PrizeMoney.MATCH_COUNT_FOR_FIRST_PLACE);
        assertEquals(expected, actual);
    }
}

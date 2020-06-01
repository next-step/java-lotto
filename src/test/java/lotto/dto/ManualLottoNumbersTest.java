package lotto.dto;

import lotto.domain.ticket.LottoTicket;
import lotto.support.LottoNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ManualLottoNumbersTest {

    @DisplayName("수동 숫자를 , 기준으로 입력하면 LottoTicket으로 변환한다")
    @Test
    void makeManualLottoTicket() {
        //given
        String manulNumbers = "1, 2, 3, 4, 5, 6";
        LottoTicket expected = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(manulNumbers);
        LottoTicket lottoTicket = manualLottoNumbers.toLottoTicket();

        //then
        assertThat(lottoTicket).isEqualToComparingFieldByField(expected);
    }

}
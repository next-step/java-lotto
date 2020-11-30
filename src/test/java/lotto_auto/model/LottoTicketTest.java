package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    public void createLottoNumberTest() {

        LottoTicket lottoTicket = new LottoTicket();
        LottoNumbers lottoNumbers = lottoTicket.getLottoNumbers();
        List<LottoNumber> export = lottoNumbers.export();
        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(export).isNotNull(),
                () -> assertThat(export.size()).isEqualTo(6)
        );
    }

    @DisplayName("로또 티켓 번호 포함 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6",
            "3,4,5,6,7,8",
    }, delimiter = ':')
    public void lottoTicketContainTest(String lottoNumberString) {

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberString);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertAll(
                () -> {
                    for (LottoNumber lottoNumber : lottoNumbers.export()) {
                        assertThat(lottoTicket.contains(lottoNumber)).isEqualTo(true);
                    }
                }
        );
    }

    @DisplayName("로또 티켓 번호 포함 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:3,4,5,6,7,8:4",
            "12,13,14,15,16,17:3,4,5,6,7,8:0"
    }, delimiter = ':')
    public void lottoTicketComputeMatchCountTest(String lottoNumberString,String secondNumberString,int expected) {

        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(lottoNumberString));

        LottoNumbers lottoNumbers = new LottoNumbers(secondNumberString);

        assertThat(lottoTicket.computeMatchCount(lottoNumbers)).isEqualTo(expected);
    }

}

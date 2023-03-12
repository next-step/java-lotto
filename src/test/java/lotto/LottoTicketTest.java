package lotto;

import calculator.StringCalculator;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LottoTicketTest {


    @Test
    @DisplayName("문자열을 받아 로또 번호를 만들 수 있다.")
    public void initLottoTikcetByString() {

        String lottoNumbers = "1, 2, 3, 4, 5, 6";

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        List<Integer> lottoNumber = lottoTicket.getLottoNumbers();

        assertThat(lottoNumber)
                .hasSize(6)
                .containsExactlyInAnyOrder(1,2,3,4,5,6);
    }


    @DisplayName("로또 길이 6개 정합성 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    public void vaildLottoLength(String lottoNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

                }).withMessageContaining("로또 번호 길이 틀림");

    }


    @DisplayName("로또 번호 정합성 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    void vaildLottoNumbers(String lottoNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

                }).withMessageContaining("로또 번호 에러");
    }

    @DisplayName("로또 번호 중복 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,6,6"})
    void vaildDuplicateLottoNumbers(String lottoNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

                }).withMessageContaining("로또 번호 중복");
    }

    @DisplayName("랜덤으로 번호 뽑을 수 있다.")
    @Test
    public void makeRandomLottoNumbers() {

        LottoTicket lottoTicket = new LottoTicket();

        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();

        assertThat(lottoNumbers)
                .hasSize(6);
    }


    @ParameterizedTest
    @CsvSource(value = {
              "'1,2,3,4,5,6','1,2,3,8,9,10',7,5등"
            , "'1,2,3,4,5,6','1,2,3,5,8,9',7,4등"
            , "'1,2,3,4,5,6','1,2,3,4,5,9',7,3등"
            , "'1,2,3,4,5,6','1,2,3,4,5,9',6,2등"
            , "'1,2,3,4,5,6','1,2,3,4,5,6',7,1등"
    })
    void winningLottoTest(String buyLottoNumbers, String winningLottoNumber, int bounsNumber ,String name){

        LottoTicket lottoTicket = new LottoTicket(buyLottoNumbers);

        LottoTicket winningNumber = new LottoTicket(winningLottoNumber);

        WinningLotto winningLotto = lottoTicket.getWinnerLotto(winningNumber, bounsNumber);

        assertThat(winningLotto.name).isEqualTo(name);
    }

}

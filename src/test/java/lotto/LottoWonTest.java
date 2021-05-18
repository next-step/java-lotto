package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWon;
import lotto.util.LottoStringFixtureUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoWonTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,5,8,9", "10,11,12,13,14,15"})
    @DisplayName("로또승리는_6개의_로또번호를_가진다")
    public void 로또승리는_6개의_로또번호를_가진다(String fixtureLottoNumber) {
        assertDoesNotThrow(() -> new LottoWon(LottoStringFixtureUtil.convertStringToLottoNumberList(fixtureLottoNumber)));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "1,2,3,4,5,6#6",
                    "11,2,3,4,5,6#5",
                    "11,12,3,4,5,6#4",
                    "11,12,13,4,5,6#3",
                    "11,12,13,14,5,6#2",
                    "11,12,13,14,15,6#1",
                    "11,12,13,14,15,16#0"
            },
            delimiter = '#'
    )
    @DisplayName("로또를 입력받아 몇개를 맞췄는지 알 수 있다.")
    public void 로또를_입력받아_몇개를_맞췄는지_알_수_있다(String fixtureLottoNumber, int countOfMatched) {
        LottoWon lottoWon = new LottoWon(LottoStringFixtureUtil.convertStringToLottoNumberList("1,2,3,4,5,6"));
        LottoTicket lottoTicket = new LottoTicket(LottoStringFixtureUtil.convertStringToLottoNumberList(fixtureLottoNumber));

        assertThat(lottoWon.match(lottoTicket))
                .isEqualTo(countOfMatched);
    }
}

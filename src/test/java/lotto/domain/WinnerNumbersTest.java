package lotto.domain;

import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinnerNumbersTest {
    private WinnerNumbers winnerNumbers;

    @BeforeEach
    public void beforeEach() {
        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.manualGenerator(lottoNumberText);

        winnerNumbers = WinnerNumbers.create(lottoNumbers);
    }
    
    @DisplayName("당첨 번호가 6개가 아닐때 예외")
    @Test
    public void invalidWinnerNumberCountTest() {
        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5");
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.manualGenerator(lottoNumberText);

        assertThatThrownBy(() -> WinnerNumbers.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또티켓과 당첨번호 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"FIRST:1:2:3:4:5:6",
            "SECOND:1:2:3:4:5:7",
            "THIRD:1:2:3:4:10:7",
            "FOURTH:1:2:3:20:11:13",
            "MISS:1:2:30:25:10:9",
            "MISS:1:17:30:25:10:9",
            "MISS:27:17:30:25:10:9"}, delimiter = ':')
    public void createLottoTicket(String rankName, String lottoNumber1, String lottoNumber2,
                                  String lottoNumber3, String lottoNumber4,
                                  String lottoNumber5, String lottoNumber6) {
        List<String> lottoNumberText = Arrays.asList(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6);
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.manualGenerator(lottoNumberText);
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        LottoRank lottoRank = winnerNumbers.checkLottoTicket(lottoTicket);

        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(rankName));
    }

}

package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinnerNumbersTest {
    private WinnerNumbers winnerNumbers;

    @BeforeEach
    public void beforeEach() {
        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5", "6");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(lottoNumberText);


        winnerNumbers = WinnerNumbers.create(lottoNumbers);
    }
    
    @DisplayName("로또당첨번호의 갯수는 6개여야한다.")
    @Test
    public void invalidWinnerNumberCountTest() {
        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(lottoNumberText);

        assertThatThrownBy(() -> WinnerNumbers.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또티켓과 당첨번호 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"FIRST|1,2,3,4,5,6",
            "SECOND|1,2,3,4,5,7",
            "THIRD|1,2,3,4,10,7",
            "FOURTH|1,2,3,20,11,13",
            "MISS|1,2,30,25,10,9",
            "MISS|1,17,30,25,10,9",
            "MISS|27,17,30,25,10,9"}, delimiter = '|')
    public void createLottoTicket(String rankName, String lottoNumber) {
        String[] splitedLottoNumber = StringUtils.split(lottoNumber);
        List<String> lottoNumberText = Arrays.asList(splitedLottoNumber);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(lottoNumberText);

        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        LottoRank lottoRank = winnerNumbers.checkLottoTicket(lottoTicket);

        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(rankName));
    }

}

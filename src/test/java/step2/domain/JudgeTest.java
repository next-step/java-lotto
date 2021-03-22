package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoDTO.NormalLottoDTO;
import step2.dto.LottoDTO.WinningLottoDTO;
import step2.dto.LottoListDTO;
import step2.dto.ShopResponseDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setUp() {
        this.judge = new Judge();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6 : 7 : 1,2,3,10,20,30 : 1,0,0,0,0 : 5",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,10,20  : 0,1,0,0,0 : 50",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,10   : 0,0,1,0,0 : 1500",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,7    : 0,0,0,1,0 : 30000",
            "1,2,3,4,5,6 : 7 : 1,2,3,4,5,6    : 0,0,0,0,1 : 2000000"}, delimiter = ':')
    @DisplayName("당첨여부를 판단할 수 있다")
    void judgeCalculatesResult(String winningString, int rawBonusNumber, String boughtString, String expected, double expectedProfitIndex) {
        List<Integer> winningNumbers = parseIntegerListFromString(winningString);
        WinningLottoDTO winningLotto = new WinningLottoDTO(winningNumbers, rawBonusNumber);
        ShopResponseDTO shopResponse = generateShopResponse(boughtString);
        List<Integer> expectedResult = parseIntegerListFromString(expected);

        JudgeResponseDTO judgeResponse = judge.calculateResult(shopResponse, winningLotto);
        assertThat(judgeResponse.getFifthPriceCount()).isEqualTo(expectedResult.get(0));
        assertThat(judgeResponse.getForthPriceCount()).isEqualTo(expectedResult.get(1));
        assertThat(judgeResponse.getThirdPriceCount()).isEqualTo(expectedResult.get(2));
        assertThat(judgeResponse.getSecondPriceCount()).isEqualTo(expectedResult.get(3));
        assertThat(judgeResponse.getFirstPriceCount()).isEqualTo(expectedResult.get(4));
        assertThat(judgeResponse.getProfitIndex()).isEqualTo(expectedProfitIndex);
    }

    private ShopResponseDTO generateShopResponse(String boughtString) {
        List<Integer> myNumbers = parseIntegerListFromString(boughtString);
        NormalLottoDTO myLotto = new NormalLottoDTO(myNumbers);
        LottoListDTO myLottoList = new LottoListDTO(myLotto);

        return new ShopResponseDTO(1000, 1, myLottoList, 0);
    }

    private List<Integer> parseIntegerListFromString(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}

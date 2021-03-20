package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoWinnersTest {

    private String inputWinnerNumber;

    @BeforeEach
    public void setUp() {
        inputWinnerNumber = "1,2,3,4,5,6";
    }

    public LottoNumbers createWinnerNumbers(String input) {
        return new LottoNumbers(input);
    }

    public LottoNumber createBonusNumber(int number) {
        return new LottoNumber(number);
    }

    @Test
    @DisplayName("당첨 번호 관리 생성 테스트")
    public void createWinnersTest() throws Exception {
        //given
        int number = 10;
        LottoNumbers lottoNumbers = createWinnerNumbers(inputWinnerNumber);
        LottoWinners winners = new LottoWinners(lottoNumbers, createBonusNumber(number));

        //when

        //then
        assertThat(winners.checkWinners(lottoNumbers, number)).isTrue();
    }
}

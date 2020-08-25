package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private List<LottoNumber> LOTTO_NUMS = Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(3), new LottoNumber(17), new LottoNumber(24), new LottoNumber(35), new LottoNumber(44)});

    @Test
    @DisplayName("로또 세트 생성 테스트")
    public void createLotto(){
        Lotto lotto = new Lotto(LOTTO_NUMS);
        assertThat(lotto.getSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 세트 생성시 중복 오류 테스트")
    public void createLottoException(){
        List<LottoNumber> duplicatedLottoNums = Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(2), new LottoNumber(2), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)});

        assertThatIllegalArgumentException().isThrownBy(()-> new Lotto(duplicatedLottoNums));
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 갯수 테스트 (당첨갯수:당첨로또번호)")
    @ValueSource(strings = {"6:1,3,17,24,35,44", "5:2,3,17,24,35,44", "4:2,4,17,24,35,44",
            "3:2,4,15,24,35,44","2:2,4,15,20,35,44","1:2,4,15,20,34,44","0:2,4,15,20,36,45"})
    public void countWinningNumberTest(String input){
        //given
        String[] tokens = input.split(":");
        int expectedMatchedCount = Integer.parseInt(tokens[0]);
        String[] winningNumbers = tokens[1].split(",");

        List<LottoNumber> winningNums = LottoNumber.makeLottoNums(winningNumbers);
        Lotto lotto = new Lotto(LOTTO_NUMS);

        int actualMathcedCount = 0;
        //when
        for(LottoNumber winningNum : winningNums){
            actualMathcedCount = lotto.countWinningNumber(winningNum);
        }

        //then
        assertThat(actualMathcedCount).isEqualTo(expectedMatchedCount);
        assertThat(lotto.getSize()).isEqualTo(6);
    }
}

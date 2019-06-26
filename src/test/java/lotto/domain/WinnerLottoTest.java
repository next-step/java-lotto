package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerLottoTest {
    private WinnerLotto winnerLotto;
    private String wrongLottoNumbers = "0,2,3,4,,6,46";
    private String[] wrongStringNumbers;
    private List<Integer> overRangeNumbers;

    @BeforeEach
    void setUp() {
        overRangeNumbers = new ArrayList<>();
        overRangeNumbers.add(0);
        overRangeNumbers.add(2);
        overRangeNumbers.add(3);
        overRangeNumbers.add(4);
        overRangeNumbers.add(5);
        overRangeNumbers.add(6);
        overRangeNumbers.add(46);
        winnerLotto = new WinnerLotto("1,2,3,4,5,6");
        wrongStringNumbers = winnerLotto.getStrNumbers(wrongLottoNumbers);
    }

    @Test
    void getStrNumbers_쉼표로문자열자르기() {
        assertThat(wrongStringNumbers.length).isEqualTo(7);
    }

    @Test
    void 잘못된숫자범위로또번호_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            for (String wrongStringNumber : wrongStringNumbers) {
                winnerLotto.checkLottoNumberRange(wrongStringNumber);
            }
        });
    }

    @Test
    void 빈문자열_NULL_공백문자열_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winnerLotto.checkInputNullOrEmpty("");
            winnerLotto.checkInputNullOrEmpty(null);
            winnerLotto.checkInputNullOrEmpty(" ");
        });

    }

    @Test
    void 로또숫자개수초과_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winnerLotto.checkNumbersLength(wrongStringNumbers);
        });
    }

    @Test
    void 숫자형태가아닌문자열_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            for (String wrongStringNumber : wrongStringNumbers) {
                winnerLotto.checkNumberValue(wrongStringNumber);
            }
        });
    }

    @Test
    void 문자열받는생성자로유효성검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winnerLotto = new WinnerLotto(wrongLottoNumbers);
        });
    }

    @Test
    void 여섯개숫자지만중복숫자있는지검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winnerLotto = new WinnerLotto("1,2,3,4,5,5");
        });
    }

    @Test
    void 정상적인로또번호입력() {
        assertThat(winnerLotto.getNumbers().size()).isEqualTo(6);
    }

}

package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {3,5,6,7,8,9})
    @DisplayName("당첨번호 매치 테스트")
    public void winningNumbersMatch(int value){
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3,5,6,7,8,9));
        assertThat(winningNumbers.getWinningNumbers()).contains(value);
    }

    @Test
    @DisplayName("당첨번호가 6개 이상이 들어올 경우 테스트")
    public void winningNumbersSizeException(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(3,5,6,7,8,9,10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개만 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 일치할 때")
    public void bonusNumberExceptionCheck(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(3,5,6,7,8,9),9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 당첨번호에 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("빈값 테스트")
    public void winningNumbersNullPointException(){
        assertThatThrownBy(() -> new WinningNumbers(new ArrayList<>()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("빈값이 들어왔습니다.");
    }
}

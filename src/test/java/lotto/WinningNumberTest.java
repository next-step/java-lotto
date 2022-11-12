package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {3,5,6,7,8,9})
    @DisplayName("당첨번호 매치 테스트")
    public void winningNumbersMatch(int value){
        WinningNumbers winningNumbers = new WinningNumbers("3,5,6,7,8,9");
        assertThat(winningNumbers.getWinningNumbers()).contains(value);
    }

    @Test
    @DisplayName("당첨번호가 6개 이상이 들어올 경우 테스트")
    public void winningNumbersSizeException(){
        assertThatThrownBy(() -> new WinningNumbers("3,5,6,7,8,9,10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개만 입력해주세요.");
    }

    @Test
    @DisplayName("빈값 테스트")
    public void winningNumbersNullPointException(){
        assertThatThrownBy(() -> new Lottos(new ArrayList<>()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("빈값이 들어왔습니다.");
    }
}

package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    List<Integer> lottoNumbers;

    @BeforeEach
    void init(){
        lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("보너스 번호 예외 테스트")
    void bonusNumber_exception(){
        int bonusNumber = 6;
        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 결과 조회(result 테스트)")
    void results_test(){
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 6, 7), 44);

        MatchingResult results = winningNumber.results(myNumbers);
        assertThat(results).isEqualTo(new MatchingResult(5, false));

    }


}




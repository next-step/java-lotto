package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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


}




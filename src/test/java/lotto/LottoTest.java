package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 생성시 로또 번호 리스트의 길이가 6이 아니면 에러.")
//    @ParameterizedTest
//    @MethodSource() 추후 리스트 던져주는 함수 구현시 사용
    @Test
    void validateLottoListTest() {
        Integer[] lottoNumbers = {1,2,3,4,5,6,7};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    new Lotto(Arrays.asList(lottoNumbers));
                });
    }
}

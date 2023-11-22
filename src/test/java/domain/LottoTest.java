package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 번호를 생성하는 경우 정렬되어 저장한다. - 숫자 입력 정적 팩토리 활용")
    void lottoNumberInputTest() {
        Lotto lotto = new Lotto(3,2,5,11,1,8);

        assertThat(lotto.getLottoNumbers()).isEqualTo(Arrays.asList(1,2,3,5,8,11));
    }
    @Test
    @DisplayName("로또 번호를 생성하는 경우 정렬되어 저장한다. - 문자 입력 정적 팩토리 활용")
    void lottoStringInputTest() {
        Lotto lotto = new Lotto("3,2,5,11,1,8");

        assertThat(lotto.getLottoNumbers()).isEqualTo(Arrays.asList(1,2,3,5,8,11));
    }
}

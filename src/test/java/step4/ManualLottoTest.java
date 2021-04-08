package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.InputNumber;
import step2.Domain.Lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoTest {
    @Test
    @DisplayName("수동로또 생성 테스트")
    void manual_lotto_test(){
        String manualNumbers = "1,2,3,4,5,6";
        assertThat(new Lotto(new InputNumber(manualNumbers))).isEqualTo(new Lotto(new InputNumber(manualNumbers)));
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 6개가 아닐 경우")
    void manual_lotto_test_6개가_아닐_경우(){
        String manualNumbers = "1,2,3,4,5,6,7";
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(new InputNumber(manualNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 중복일 경우")
    void manual_lotto_test_중복일_경우(){
        String manualNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(new InputNumber(manualNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 문자가 들어간 경우")
    void manual_lotto_test_문자가_들어간_경우(){
        String manualNumbers = "1,2,3,4,a,5";
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(new InputNumber(manualNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

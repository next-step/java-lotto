package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class AutoLottoTest {
    private AutoLotto autoLotto;

    @BeforeEach
    void set_up(){
        autoLotto = new AutoLotto();
    }

    @Test
    void lotto_valid_test(){
        assertThat(autoLotto.size()).isEqualTo(6);
    }


    /**
     * 1~45까지 숫자만 허용
     */
    @Test
    void lotto_number_valid_test(){
        System.out.println(Arrays.toString(autoLotto.getNumbers()));
        assertThat(autoLotto.getNumbers()).contains(1);
    }



}
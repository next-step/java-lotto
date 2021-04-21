package Lotto;

import lotto.domain.GenerateLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateLottoTest {

    @Test
    @DisplayName("로또의 숫자범위가 1~45로 알맞게 생성되는지 확인")
    public void check_validate_number(){
        GenerateLotto generateLotto = new GenerateLotto();
        List<Integer> lottoNumbers = generateLotto.generateAuto();
        for (int i =0 ; i < 6; i++){
            Assertions.assertThat(lottoNumbers.get(i)).isLessThan(46).isGreaterThan(0);
        }

    }

    @Test
    @DisplayName("로또 넘버가 자동으로 잘 생성되는지 확인")
    public void generate_auto_lotto(){
        GenerateLotto lottoNumber = new GenerateLotto();
        List<Integer> lottoNumbers = lottoNumber.generateAuto();
        System.out.println("로또 넘버는"+lottoNumbers.toString());
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);

    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ExceedNumberException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CreateAutoNumberMachine;

class LottoNumbersTest {

    @DisplayName("로또 번호 충족하지 않을 때 ExceedSizeException 발생")
    @Test
    public void checkExceedSizeNumbers(){
        List<LottoNumber> list = CreateAutoNumberMachine
            .createNumber(
                Arrays.asList(1,2,3,4,5,6,7));
        assertThatThrownBy(() ->
            new LottoNumbers(list))
            .isInstanceOf(ExceedNumberException.class);
    }

    @DisplayName("로또 번호 생성")
    @Test
    public void createNumbers(){
        LottoNumbers lottoNumbers =
            CreateAutoNumberMachine
                .createNumbers(Arrays
                    .asList(1,2,3,4,5,6)
                );
        assertThat(lottoNumbers).isEqualTo(lottoNumbers);
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.DuplicateNumberException;
import exception.ExceedNumberException;
import exception.NegativeException;
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

    @DisplayName("로또 번호 초과 시 에러 체크")
    @Test
    public void checkExceedSizeException(){
        assertThatThrownBy(() -> CreateAutoNumberMachine.createNumbers(Arrays.asList(0,1,2,3,4,5,6,7)))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 음수가 있는 경우 에러 발생")
    @Test
    public void checkNegativeNumberException(){
        assertThatThrownBy( () ->
            CreateAutoNumberMachine.createNumbers(
                Arrays.asList(-11,2,3,4,5,6))
            )
            .isInstanceOf(ExceedNumberException.class);
    }

    @DisplayName("로또 번호 범위 초과")
    @Test
    public void validateExceedNumber(){
        assertThatThrownBy( () ->
            CreateAutoNumberMachine.createNumbers(
                Arrays.asList(8,1,2,3,4,46))
            )
            .isInstanceOf(ExceedNumberException.class);
    }

    @DisplayName("로또 중복 번호")
    @Test
    public void DuplicateNumber(){
        assertThatThrownBy( () ->
            CreateAutoNumberMachine.createNumbers(
                Arrays.asList(1,1,2,3,4,45))
        ).isInstanceOf(DuplicateNumberException.class);
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

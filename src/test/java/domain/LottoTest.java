package domain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ExceedNumberException;
import exception.ExceedSizeException;
import exception.NegativeException;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CreateAutoNumberMachine;

class LottoTest {

    @DisplayName("로또 번호 초과 시 에러 체크")
    @Test
    public void checkExceedSizeException(){
        assertThatThrownBy( () ->
            new Lotto(
                CreateAutoNumberMachine.createNumbers(Arrays.asList(0,1,2,3,4,5,6,7))
            ))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 음수가 있는 경우 에러 발생")
    @Test
    public void checkNegativeNumberException(){
        assertThatThrownBy( () ->
            new Lotto(
                CreateAutoNumberMachine.createNumbers(
                    Arrays.asList(-11,2,3,4,5,6)
                )
            ))
            .isInstanceOf(NegativeException.class);
    }

    @DisplayName("로또 번호 범위 초과")
    @Test
    public void validateExceedNumber(){
        assertThatThrownBy( () ->
            new Lotto(
                CreateAutoNumberMachine.createNumbers(
                    Arrays.asList(8,1,2,3,4,46)
                )
            ))
            .isInstanceOf(ExceedNumberException.class);
    }

    @DisplayName("로또 생성")
    @Test
    public void createLotto(){
        Lotto lotto = new Lotto(
            CreateAutoNumberMachine.createNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto.getLottoNumbers())
            .isEqualTo(CreateAutoNumberMachine.createNumbers(Arrays.asList(1,2,3,4,5,6)));
    }
}

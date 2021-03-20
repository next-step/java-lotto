package domain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호 초과 시 에러 체크")
    @Test
    public void checkNumberLengthException(){

        assertThatThrownBy( () ->
            new Lotto(
                Sets.newHashSet(
                    Arrays.asList(0,1,2,3,4,5,6,7)
                )
            ))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 음수가 있는 경우 에러 발생")
    @Test
    public void checkNegativeNumberException(){
        assertThatThrownBy( () ->
            new Lotto(
                Sets.newHashSet(
                    Arrays.asList(-11,2,3,4,5,6)
                )
            ))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 범위 초과")
    @Test
    public void validateExceedNumber(){
        assertThatThrownBy( () ->
            new Lotto(
                Sets.newHashSet(
                    Arrays.asList(0,1,2,3,4,46)
                )
            ))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("중복 번호 체크")
    @Test
    public void duplicateNumberException(){
        assertThatThrownBy( () ->
            new Lotto(
                Sets.newHashSet(
                    Arrays.asList(1,1,2,3,4,6)
                )
            ))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 생성")
    @Test
    public void createLotto(){
        Lotto lotto = new Lotto(
            Sets.newHashSet(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto.getNumbers())
            .isEqualTo(Sets.newHashSet(Arrays.asList(1,2,3,4,5,6)));
    }
}

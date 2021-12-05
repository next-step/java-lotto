package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAssignMachineTest {

    private LottoAssignMachine lottoAssignMachine;

    @BeforeEach
    void init() {
        lottoAssignMachine = new LottoAssignMachine(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName(value = "수동으로 입력한 번호가 출력 되어야 한다.")
    void publishTest() {
        assertThat(lottoAssignMachine.publish()).isEqualTo(
            new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName(value = "로또 번호는 6개가 출력되어야 한다.")
    void publishLottoSizeTest() throws NoSuchFieldException, IllegalAccessException {
        List<LottoNumber> lottoNumbers = getNumbersByReflection(lottoAssignMachine.publish());
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName(value = "로또번호가 6개가 아니면, 예외가 발생한다")
    void publishExceptionTest() {
        lottoAssignMachine = new LottoAssignMachine(Arrays.asList(1, 2, 3, 4, 5));

        assertThatIllegalArgumentException()
            .isThrownBy(() -> lottoAssignMachine.publish());
    }

    @SuppressWarnings("unchecked")
    private List<LottoNumber> getNumbersByReflection(LottoTicket lottoTicket)
        throws NoSuchFieldException, IllegalAccessException {
        Field numbersField = LottoTicket.class.getDeclaredField("numbers");
        numbersField.setAccessible(true);
        return (List<LottoNumber>) numbersField.get(lottoTicket);
    }
}
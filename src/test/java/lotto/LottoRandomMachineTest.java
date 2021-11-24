package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRandomMachineTest {

    @Test
    @DisplayName("로또번호의 갯수는 6이어야 한다.")
    void publishTest() throws NoSuchFieldException, IllegalAccessException {
        LottoMachine lottoMachine = new LottoRandomMachine();

        LottoTicket publish = lottoMachine.publish();
        List<Integer> numbers = getNumbersByReflection(publish);
        assertThat(numbers).hasSize(6);
    }

    @SuppressWarnings("unchecked")
    private List<Integer> getNumbersByReflection(LottoTicket lottoTicket)
        throws NoSuchFieldException, IllegalAccessException {
        Field numbersField = LottoTicket.class.getDeclaredField("numbers");
        numbersField.setAccessible(true);
        return (List<Integer>) numbersField.get(lottoTicket);
    }
}
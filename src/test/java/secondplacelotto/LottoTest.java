package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.exception.isNotScopeInTheNumberException;
import secondplacelotto.model.Lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 1부터 45까지 숫자가 아닐 시 예외처리가 되는가")
    public void createLottoException() {
        String[] numbers = {"0","1","2","3","4","5"};

        assertThrows(isNotScopeInTheNumberException.class, () ->
                new Lotto(numbers));

    }
}

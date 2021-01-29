package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketGeneratorTest {

    @DisplayName("입력된 숫자에 따라서 로또 티켓이 잘 생성되는지 확인")
    @Test
    void generateManualTicket() {
        assertEquals(
            new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                    add(new LottoNumber(2));
                    add(new LottoNumber(3));
                    add(new LottoNumber(4));
                    add(new LottoNumber(5));
                    add(new LottoNumber(6));
                }}
            ),
            LottoTicketGenerator.generateManualTicket(
                "1, 2, 3, 4, 5, 6"
            )
        );
    }

    @DisplayName("입력된 값을 통해 로또 티켓을 만들 수 없는 경우 예외를 잘 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {
        "1, 2, 3, 4, 5, 0",
        "1, 2, 3, 4, 5",
        "1, 2, 3, 4, 5, 6, 7",
        "1, 2, 3, 4, 5, O",
    })
    void generateManualTicketNotValid(String manualNumbers) {
        assertThrows(
            RuntimeException.class,
            () -> LottoTicketGenerator.generateManualTicket(manualNumbers)
        );
    }
}
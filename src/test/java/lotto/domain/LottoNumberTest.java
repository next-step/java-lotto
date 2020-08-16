package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {

    private Ticket ticket;

    @BeforeEach
    public void setup() {
        ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void makeLottoNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(ticket);
        assertEquals(lottoNumber.getNumbers(), ticket.getNumbers());
    }

    @Test
    public void makeLottoResultNumberTest() {
        LottoResultNumber lottoResultNumber = new LottoResultNumber(ticket);
        assertEquals(lottoResultNumber.getNumbers(), ticket.getNumbers());
    }

    @Test
    public void toStringTest() {
        LottoNumber lottoNumber = new LottoNumber(ticket);
        assertEquals(ticket.toString(), lottoNumber.toString());
    }
}

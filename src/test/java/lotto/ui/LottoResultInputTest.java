package lotto.ui;

import common.StringResources;
import lotto.domain.RandomLottoCreator;
import lotto.domain.LottoResultNumber;
import lotto.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultInputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void lottoResultInputSuccess() {

        Ticket ticket = RandomLottoCreator.createTicket();
        LottoResultInput lottoResultInput = new LottoResultInput(new LottoResultNumber(ticket));

        String outputText = StringResources.MSG_WINNING_NUMBER + "\n" +
                lottoResultInput.getLottoResultNumber().toString() + "\n";

        assertEquals(outputText, outContent.toString());
        assertEquals(ticket.getNumbers(), lottoResultInput.getLottoResultNumber().getNumbers());
    }
}

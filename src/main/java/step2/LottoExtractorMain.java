package step2;

import step2.model.LottoNumberGenerator;
import step2.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoExtractorMain {
    public static void main(String[] args) {
        int trials = 10;
        List<LottoTicket> ticketList = new ArrayList<>();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        for (int i = 0; i < trials; i++) {
            ticketList.add(new LottoTicket(generator.retrieveLottoNumberList()));
        }
    }
}

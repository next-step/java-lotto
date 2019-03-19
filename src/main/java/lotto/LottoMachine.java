package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private LottoNumGenerator lottoNumGenerator;

    public LottoMachine(LottoNumGenerator lottoNumGenerator) {
        this.lottoNumGenerator = lottoNumGenerator;
    }

    public List<LottoTicket> buyLottoTicket(int amount) {
        int salesQuantity = getSalesQuantity(amount);
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < salesQuantity; i++) {
            lottoTickets.add(new LottoTicket(lottoNumGenerator.generateTicket()));
        }

        return lottoTickets;

    }


    private int getSalesQuantity(int amount) {
        return amount / 1000;
    }}

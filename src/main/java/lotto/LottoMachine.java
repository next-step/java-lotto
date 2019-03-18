package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_NO = 45;
    private List<Integer> lottoNumbers;

    private int salesQuantity;


    public LottoMachine() {
        this.lottoNumbers = createNumbers();
//        this.salesQuantity = getSalesQuantity(amount);
    }

    private int getSalesQuantity(int amount) {
        return amount / 1000;
    }

    public List<LottoTicket> buyLottoTicket(int amount) {
        this.salesQuantity = getSalesQuantity(amount);
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < salesQuantity; i++) {
            lottoTickets.add(new LottoTicket(generateTicket()));
        }

        return lottoTickets;
    }


    private List<Integer> generateTicket() {
        List<Integer> ticket = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
//        System.out.println("shuffle numbers = " + lottoNumbers.toString());
        for (int i = 0; i < 6; i++) {
            ticket.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoNumbers);
//        System.out.println("sort Number = " + lottoNumbers.toString());
        return ticket;
    }

    public List<Integer> createNumbers() {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_NO; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}

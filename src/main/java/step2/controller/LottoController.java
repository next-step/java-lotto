package step2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoController {

    private static final int LOTTO_TOTAL_COUNT = 6;
    private final int lottoAmount;
    private int qty;
    private List<List<Integer>> lottos = new ArrayList<>();

    public LottoController(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        lottoTicketCreateStart();
    }

    public static LottoController of(int lottoAmount) {
        return new LottoController(lottoAmount);
    }

    private int lottoQty() {
        return this.lottoAmount / 1000;
    }

    public void lottoTicketCreateStart() {
        this.qty = lottoQty();
        for (int i = 0; i < this.qty; i++) {
            this.lottos.add(lottoTicketCreate());
        }
    }

    private List<Integer> lottoTicketCreate() {
        List<Integer> ticket = new ArrayList<>();
        for (int j = 0; j < LOTTO_TOTAL_COUNT; j++) {
            ticket.add(random());
        }
        Collections.shuffle(ticket, new Random());
        Collections.sort(ticket);
        return ticket;
    }

    private int random() {
        return (int) (Math.random() * 45) + 1;
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }

    public List<Integer> getLottoTicket(int i) {
        return this.lottos.get(i);
    }
//    public int totalSta
}

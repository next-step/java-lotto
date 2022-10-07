package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private int ticket;
    public LottoTickets(int money) {
        this.ticket = money / 1000;
    }

    public int createTickets() {
        LottoNumberRandomGenerator lottoNumberRandomGenerator = new LottoNumberRandomGenerator();
        List<List<Integer>> lotto = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            List<Integer> generateNumberList = lottoNumberRandomGenerator.generate();
            lotto.add(generateNumberList);
        }
        for (List<Integer> integers : lotto) {
            System.out.println(integers);
        }
        return this.ticket;
    }
}

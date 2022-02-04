package lotto.domain;

import static lotto.util.Constant.*;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Lotto {

    List<LottoNumbers> lottoTickets;

    public int buyLottoTickets(int money) {
        return money / PRICE;
    }

    public void generateLottoTickets(int number) {
        List<LottoNumbers> temp = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            temp.add(new LottoNumbers(generateRandoms()));
        }
        lottoTickets = temp;
    }

    public List<Integer> generateRandoms() {
        List<Integer> numberCards = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberCards.add(i);
        }
        Collections.shuffle(numberCards);

        List<Integer> picked = numberCards.subList(0, LOTTO_SIZE);
        Collections.sort(picked);
        return picked;
    }

    public int getNumOfTickets() {
        return lottoTickets.size();
    }
}

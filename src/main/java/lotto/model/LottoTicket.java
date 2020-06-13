package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private Lotto lotto = new Lotto();
    private List<Integer> myNumbers;
    private int rank = 0;

    public LottoTicket() {
        myNumbers = buyTicket();
    }

    public LottoTicket(int[] numbers) {
        this.myNumbers = arrToList(numbers);
    }

    public List<Integer> buyTicket() {
        Collections.shuffle(lotto.lottoDrawNumbers);
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < Lotto.LIMIT; i++) {
            numbers.add(lotto.lottoDrawNumbers.get(i));
        }

        return numbers;
    }

    public int announceRank(List<Integer> winningNumbers) {
        for (int i : winningNumbers) {
            isWinner(i);
        }

        return rank;
    }
    
    private void isWinner(int winningNumber) {
        if (myNumbers.contains(winningNumber)) {
            rank++;
        }
    }

    private List<Integer> arrToList(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        return list;
    }
}

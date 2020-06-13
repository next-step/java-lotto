package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private Lotto lotto = new Lotto();
    private List<Integer> myNumbers;

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

    public int isWinner(List<Integer> winningNumbers) {
        int winningRank = 0;

        for (int i : winningNumbers) {
            if (myNumbers.contains(i)) {
                winningRank++;
            }
        }

        return winningRank;
    }

    private List<Integer> arrToList(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        return list;
    }
}

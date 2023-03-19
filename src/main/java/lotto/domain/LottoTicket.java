package lotto.domain;

import java.util.ArrayList;

public class LottoTicket {
    public ArrayList<Integer> numbers;

    public LottoTicket(ArrayList<Integer> lottoNumbers) {
        this.numbers = lottoNumbers;
        System.out.println(lottoNumbers.toString());
    }

    public ArrayList<Integer> getNumbers(){
        return this.numbers;
    }
}

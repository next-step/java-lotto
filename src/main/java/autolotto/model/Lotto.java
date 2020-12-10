package autolotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers = new ArrayList<>();
    private int matchCount;

    public Lotto() {
        LottoNumbersGenerator.setLottoNumbers(numbers);
    }

    public Lotto(String[] splitNumbers) {
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
    }

    public int getNumber(int index){
        return this.numbers.get(index);
    }

    public List<Integer> getNumberList(){
        return Collections.unmodifiableList(this.numbers);
    }

    public void matchCount(Lotto winningNumber){
        for (int lottoNumber : this.numbers) {
            compareNumber(lottoNumber, winningNumber);
        }


    }

    public int isProfitable(){
        if (3 < matchCount && matchCount < 7) {
            return matchCount;
        }
        return 0;
    }

    public void refreshMatchCount(){
        this.matchCount = 0;
    }

    private void compareNumber(int lottoNumber, Lotto winningNumbers) {
        for (int winningNumber : winningNumbers.numbers){
            matchNumber(lottoNumber, winningNumber);
        }
    }

    private void matchNumber(int lottoNumber, int winningNumber){
        if (winningNumber == lottoNumber) {
            matchCount++;
        }

    }
}

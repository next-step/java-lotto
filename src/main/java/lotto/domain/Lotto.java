package lotto.domain;

import lotto.util.LottoUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> numbers = new ArrayList<>();

    Lotto(){
        List<Integer> generatedNumbers = LottoUtil.generateLottoNumber();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++){
            numbers.add(generatedNumbers.get(i));
        }

        Collections.sort(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> numbers(){
        return this.numbers;
    }

    int matchCount(List<Integer> winningNumbers) {
        int matchCount = 0;

        for(int i = 0; i < winningNumbers.size(); i++){
            matchCount = addMatchCount(matchCount, winningNumbers.get(i));
        }

        return matchCount;
    }

    public int addMatchCount(int matchCount, int winningNumber){
        if(numbers.contains(winningNumber)){
            matchCount ++;
        }

        return matchCount;
    }

    public boolean isMatchBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    public int numberOf(int idx){
        return numbers.get(idx);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

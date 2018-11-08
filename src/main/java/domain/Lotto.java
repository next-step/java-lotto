package domain;

import utils.LottoGenerator;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;
    private int combineCount = 0;

    public Lotto(int number){
        this.numbers = LottoGenerator.generateNumberList(number);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCombineCount() {
        return combineCount;
    }

    public void setCombineCount(int combineCount) {
        this.combineCount = combineCount;
    }
    //Lotto끼리 글자수비교
    public int getCombineCount(Lotto lastLotto){
        this.combineCount =  (int)numbers.stream().filter(obj->lastLotto.getNumbers().contains(obj)).count();
        return combineCount;
    }



}

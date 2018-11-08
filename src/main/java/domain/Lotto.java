package domain;

import utils.LottoGenerator;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(int number){
        numbers = LottoGenerator.generateNumberList(number);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCombineCount(Lotto lastLotto) {
        if(lastLotto == null){
            return 0;
        }
        return (int)numbers.stream().filter(obj-> isContains(lastLotto, obj)).count();
    }

    private boolean isContains(Lotto lastLotto, Integer obj) {
        return lastLotto.getNumbers().contains(obj);
    }

    public void printLotto(){
        System.out.println(this.numbers);
    }
}

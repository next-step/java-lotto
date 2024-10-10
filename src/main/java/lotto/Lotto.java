package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;
    private int matchCnt ;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchCnt(List<Integer> targetNumbers) {
        validate(targetNumbers);
        return (int) targetNumbers.stream().filter(x -> numbers.contains(x)).count();
    }

    private void validate(List<Integer> targetNumbers) {
        if(targetNumbers == null || targetNumbers.isEmpty()){
            throw new RuntimeException("유효하지 않은 당첨 로또 번호 입니다");
        }
        if (targetNumbers.size() != 6) {
            throw new RuntimeException("유효하지 않은 당첨 로또 번호 입니다");
        }
    }
}

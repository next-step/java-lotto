package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // 생성 로또번호가 6자리 이상인지 검증
        if(numbers.size() > 6){
            throw new IllegalArgumentException("6자리 초과의 로또 번호가 입력되었습니다.");
        }
        if(numbers.contains(lottoRange())){
            throw new IllegalArgumentException("1-45 범위를 벗어나는 로또 숫자가 반환되었습니다.");
        }
        if (numbers.stream().distinct().count() < numbers.size()
        ) {
            throw new IllegalArgumentException("중복되는 로또 번호가 입력되었습니다.");
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }



    public WinningType findWinningType(List<Integer> others, int bonusNumber) {
       return WinningType.valueOf(countHits(others), matchBonus(bonusNumber));
    }

    private long countHits(List<Integer> others) {
        return others.stream()
                .filter(other -> numbers.contains(other))
                .count();
    }

    private boolean matchBonus(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private static List<Integer> lottoRange() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers + "";
    }


}

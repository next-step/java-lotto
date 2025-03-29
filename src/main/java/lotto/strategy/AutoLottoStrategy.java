package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;


public class AutoLottoStrategy implements LottoStrategy {
    private static final int SELECT_COUNT = 6;

    @Override
    public List<Integer> generateLottoNumbers() {
        // LottoNumber를 통해 셔플된 번호를 가져옴
        List<Integer> shuffledNumbers = LottoNumber.getInstance().getShuffledNumbers();

        // 상위 6개 번호를 선택하고 정렬하여 반환
        return shuffledNumbers.stream()
                .limit(SELECT_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}

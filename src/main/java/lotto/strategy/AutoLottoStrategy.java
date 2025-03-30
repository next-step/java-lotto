package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class AutoLottoStrategy implements LottoStrategy {
    private static final int SELECT_COUNT = 6;

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        // LottoNumber를 통해 셔플된 번호를 가져옴
        List<LottoNumber> shuffledNumbers = LottoNumber.getShuffledNumbers();

        // 상위 6개 번호를 선택하고 정렬하여 반환
        return shuffledNumbers.stream()
                .limit(SELECT_COUNT)
                .sorted(Comparator.comparingInt(LottoNumber::getNumber)) // 숫자 기준 오름차순 정렬
                .collect(Collectors.toList());
    }
}

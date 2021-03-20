package lotto.domain;

import lotto.common.LottoConstants;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(String number) {
        this(lottoNumbers(number));
    }

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;

        if (!normal() || !normalSize()) {
            throw new IllegalArgumentException("로또 번호 생성에 실패 했습니다.");
        }
    }

    private static List<Integer> lottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public boolean normal() {
        return Collections.min(numbers) >= LottoConstants.MIN_LOTTO_NUMBER && Collections.max(numbers) <= LottoConstants.MAX_LOTTO_NUMBER;
    }

    public boolean normalSize() {
        return new HashSet<>(numbers).size() == LottoConstants.LOTTO_NUMBER_COUNT;
    }

    public int correctCount(List<Integer> winningNumbers) {
        List<Integer> tempNumbers = new ArrayList<>(winningNumbers);
        tempNumbers.removeAll(numbers);
        return LottoConstants.LOTTO_NUMBER_COUNT - tempNumbers.size();
    }

    public boolean matchedBonusBall(int bonusBall) {
        return numbers.stream().anyMatch(number -> number == bonusBall);
    }

    public String printInfo(){
        return ((List<Integer>) new ArrayList<>(numbers)).toString();
    }

}


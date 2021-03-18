package lotto.domain;

import lotto.common.LottoConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(String number) {
        this.numbers = lottoNumbers(number);
    }

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;

        if (!normal() || !normalSize()) {
            throw new IllegalArgumentException("로또 번호 생성에 실패 했습니다.");
        }
    }

    private List<Integer> lottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.replace(" ", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public boolean normal() {
        return Collections.min(numbers) >= LottoConstants.MIN_LOTTO_NUMBER && Collections.max(numbers) <= LottoConstants.MAX_LOTTO_NUMBER;
    }

    public boolean normalSize() {
        return numbers.size() == LottoConstants.LOTTO_NUMBER_COUNT;
    }

    public int correctCount(LottoNumbers purchaseLottoNumber){
        List<Integer> tempNumbers = new ArrayList<>(purchaseLottoNumber.numbers);
        tempNumbers.removeAll(numbers);
        return LottoConstants.LOTTO_NUMBER_COUNT - tempNumbers.size();
    }

    public String printInfo(){
        List<Integer> collect = new ArrayList<>(numbers);
        return collect.toString();
    }

}


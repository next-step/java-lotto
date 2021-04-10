package lotto.domain;

import lotto.common.LottoConstants;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        normalSize(numbers);
        this.lottoNumbers = numbers;
    }

    public LottoNumbers(String number) {
        this(lottoNumbers(number));
    }

    private static List<LottoNumber> lottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(String::trim)
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }

    private void normalSize(List<LottoNumber> lottoNumbers) {
        if (!(new HashSet<>(lottoNumbers).size() == LottoConstants.LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException("로또 번호 생성에 실패 했습니다.");
        }
    }

    public int correctCount(List<LottoNumber> winningNumbers) {
        List<LottoNumber> tempNumbers = new ArrayList<>(winningNumbers);
        tempNumbers.removeAll(lottoNumbers);
        return LottoConstants.LOTTO_NUMBER_COUNT - tempNumbers.size();
    }

    public boolean matchedBonusBall(LottoNumber bonusBall) {
        return lottoNumbers.stream().anyMatch(number -> number == bonusBall);
    }

    public String printInfo(){
        return ((List<LottoNumber>) new ArrayList<>(lottoNumbers)).toString();
    }

}


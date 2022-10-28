package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final Integer MATCH_NUMBER_LIST_SIZE = 6;
    private static final String VALIDATE_MATCH_NUMBER_SIZE_MESSAGE = "중복되지 않는 " + MATCH_NUMBER_LIST_SIZE + "개 숫자를 입력해 주세요.";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = validateLottoNumbers(lottoNumbers)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }

    public Boolean isValidBonusNumber(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    private List<Integer> validateLottoNumbers(List<Integer> matchNumberList) {
        Integer deduplicationNumberListSize = getDeduplicationNumberListSize(matchNumberList);
        if (!(deduplicationNumberListSize.equals(MATCH_NUMBER_LIST_SIZE))) {
            throw new InvalidInputException(VALIDATE_MATCH_NUMBER_SIZE_MESSAGE);
        }
        return matchNumberList;
    }

    private Integer getDeduplicationNumberListSize(List<Integer> matchNumberList) {
        return new HashSet<>(matchNumberList).size();
    }
}

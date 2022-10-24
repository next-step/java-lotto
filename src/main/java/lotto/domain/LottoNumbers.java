package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.HashSet;
import java.util.List;

import static lotto.util.NumberUtil.makeAutoNumberList;

public class LottoNumbers {

    private static final Integer MATCH_NUMBER_LIST_SIZE = 6;
    private static final String VALIDATE_MATCH_NUMBER_SIZE_MESSAGE = "당첨 번호는 중복되지 않는 " + MATCH_NUMBER_LIST_SIZE + "개 숫자를 입력해 주세요.";

    private final List<Integer> lottoNumberList;

    public LottoNumbers() {
        this(makeAutoNumberList());
    }

    public LottoNumbers(List<Integer> lottoNumberList) {
        this.lottoNumberList = validateLottoNumberList(lottoNumberList);
    }

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }

    public Integer getMatchCount(LottoNumbers lottoNumbers) {
        return (int) this.lottoNumberList
                .stream()
                .filter(lottoNumbers.lottoNumberList::contains)
                .count();
    }

    private List<Integer> validateLottoNumberList(List<Integer> matchNumberList) {
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

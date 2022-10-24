package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.HashSet;
import java.util.List;

import static lotto.util.NumberUtil.makeAutoNumberList;

public class LottoNumbers {

    private static final Integer MATCH_NUMBER_LIST_SIZE = 6;
    private static final String VALIDATE_MATCH_NUMBER_SIZE_MESSAGE = "당첨 번호는 중복되지 않는 " + MATCH_NUMBER_LIST_SIZE + "개 숫자를 입력해 주세요.";
    private static final String VALIDATE_BONUS_NUMBER = "보너스 볼은 지난 주 당첨 번호와 중복될 수 없습니다.";

    private final List<Integer> lottoNumberList;
    private Integer bonusNumber;

    public LottoNumbers() {
        this(makeAutoNumberList());
    }

    public LottoNumbers(List<Integer> lottoNumberList, Integer bonusNumber) {
        this.lottoNumberList = validateLottoNumberList(lottoNumberList);
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    public LottoNumbers(List<Integer> lottoNumberList) {
        this.lottoNumberList = validateLottoNumberList(lottoNumberList);
    }

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }

    public Rank getMatchCount(LottoNumbers winnerLottoNumbers) {
        int count = getCount(winnerLottoNumbers);

        if (count == Rank.THIRD.getCountOfMatch()) {
            return this.lottoNumberList.contains(winnerLottoNumbers.bonusNumber) ? Rank.SECOND : Rank.THIRD;
        }

        return Rank.valueOf(count);
    }

    private int getCount(LottoNumbers winnerLottoNumbers) {
        return (int) this.lottoNumberList
                .stream()
                .filter(winnerLottoNumbers.lottoNumberList::contains)
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

    private Integer validateBonusNumber(Integer bonusNumber) {
        if (this.getLottoNumberList().contains(bonusNumber)) {
            throw new InvalidInputException(VALIDATE_BONUS_NUMBER);
        }
        return bonusNumber;
    }

}

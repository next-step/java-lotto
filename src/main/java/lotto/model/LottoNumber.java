package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private List<Integer> numbers;
    private String issueType;

    public LottoNumber(List<Integer> numbers, String issueType) {
        validate(numbers);
        this.numbers = numbers;
        this.issueType = issueType;
    }

    public RewardStatus getRewardStatus(String[] winningNumber, int bonus) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumber.length; i++) {
            matchingCount += (numbers.contains(Integer.parseInt(winningNumber[i]))) ? 1 : 0;
        }
        return new RewardStatus(matchingCount, numbers.contains(bonus));
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        int numberSize = (int) numbers.stream().distinct().count();
        if (LottoNumberGenerator.LOTTO_CREATE_COUNT != numberSize
                || LottoNumberGenerator.LOTTO_CREATE_COUNT != numbers.size()) {
            throw new IllegalArgumentException("로또 번호 입력 에러발");
        }
        if (LottoNumberGenerator.LOTTO_RANGE_LAST_NUMBER < Collections.max(numbers)) {
            throw new IllegalArgumentException("45초과 번호 입력!!");
        }
        if (LottoNumberGenerator.LOTTO_RANGE_START_NUMBER > Collections.min(numbers)) {
            throw new IllegalArgumentException("1미만 번호 입력!!");
        }
    }

}

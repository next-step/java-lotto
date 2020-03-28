package step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final Integer COUNT_NUMBER = 6;
    public static final String LOTTO_NUMBER_DUPLICATION_ERROR = "중복되는 숫자를 가져선 안됩니다.";
    public static final String LOTTO_NUMBER_COUNT_ERROR = "정해진 개수의 숫자를 입력해주세요.";

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validateNumberCount(lotto);
        validateNumberDuplication(lotto);
        this.lotto = new ArrayList<>(lotto);
    }

    private void validateNumberDuplication(List<LottoNumber> lotto) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for(LottoNumber lottoNumber : lotto) {
            uniqueNumbers.add(lottoNumber.getValue());
        }

        if(lotto.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }

    private void validateNumberCount(List<LottoNumber> lotto) {
        if(lotto.size() != COUNT_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    public int getMatchedNumberCount(Lotto winningLotto) {
        int matchCount = 0;
        List<Integer> winningIntegerNumbers = winningLotto.getIntegerValue();

        for(int winningNumber : winningIntegerNumbers) {
            matchCount = addMatchCount(winningNumber, matchCount);
        }
        return matchCount;
    }

    private int addMatchCount(int winningNumber, int matchCount) {
        if(isMatch(winningNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    private boolean isMatch(int winningNumber) {
        List<Integer> lottoIntegerNumbers = getIntegerValue();
        return lottoIntegerNumbers.contains(winningNumber);
    }

    public List<LottoNumber> getValue() {
        return new ArrayList<>(lotto);
    }

    public List<Integer> getIntegerValue() {
        List<Integer> lottoIntegerNumbers = new ArrayList<>();

        for(LottoNumber lottoNumber : getValue()) {
            lottoIntegerNumbers.add(lottoNumber.getValue());
        }
        return lottoIntegerNumbers;
    }
}


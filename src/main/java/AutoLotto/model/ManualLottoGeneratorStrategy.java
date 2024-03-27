package autoLotto.model;

import autoLotto.exception.PurchaseException;

import java.util.*;

public class ManualLottoGeneratorStrategy implements LottoGeneratorStrategy {
    private static final String INVALID_LOTTO_NUMBERS = "쉼표를 기준으로 1 ~ 45 사이의 숫자 6개의 숫자를 중복없이 입력하셔야 합니다.\n(ex: 1,2,3,4,5,6)";
    private static final int VALID_LOTTO_LENGTH = 6;

    @Override
    public Set<LottoNumber> lottoGenerator(List<Integer> lotto) {
        return getSixNumbers(lotto);
    }

    private Set<LottoNumber> getSixNumbers(List<Integer> lotto) {
        if (!hasNotDuplicatedNumber(lotto)) {
            throw new PurchaseException(INVALID_LOTTO_NUMBERS);
        }

        List<LottoNumber> lottoNumbers = convertIntegerListToLottoNumberList(lotto);
        return new LinkedHashSet<>(lottoNumbers);
    }

    private List<LottoNumber> convertIntegerListToLottoNumberList(List<Integer> lotto) {
        Collections.sort(lotto);
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            int number = lotto.get(i);
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    private boolean hasNotDuplicatedNumber(List<Integer> lotto) {
        Set<Integer> set = new HashSet<>(lotto);

        return set.size() == VALID_LOTTO_LENGTH;
    }
}

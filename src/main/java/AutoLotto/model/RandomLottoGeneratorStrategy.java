package autoLotto.model;

import java.util.*;

public class RandomLottoGeneratorStrategy implements LottoGeneratorStrategy {
    private static final int VALID_LOTTO_LENGTH = 6;

    @Override
    public Set<LottoNumber> lottoGenerator(List<Integer> lotto) {
        shuffleRandomNumbers(lotto);
        return getSixNumbers(lotto);
    }

    private void shuffleRandomNumbers(List<Integer> lotto) {
       Collections.shuffle(lotto);
    }

    private Set<LottoNumber> getSixNumbers(List<Integer> lotto) {
        List<LottoNumber> lottoNumbers = convertIntegerListToLottoNumberList(lotto);
        return new LinkedHashSet<>(lottoNumbers);
    }

    private List<LottoNumber> convertIntegerListToLottoNumberList(List<Integer> lotto) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            int number = lotto.get(i);
            lottoNumbers.add(new LottoNumber(number));
        }

        orderByLottoNumber(lottoNumbers);
        return lottoNumbers;
    }

    private void orderByLottoNumber(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers, Comparator.comparing(LottoNumber::getLottoNumber));
    }
}

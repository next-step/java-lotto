package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.message.LottoErroMessage.NOT_ENOUGH_LOTTO_NUMBER;
import static lotto.message.LottoErroMessage.NOT_ENOUGH_LOTTO_NUMBER_DUPLICATE;

public class Lotto {

    private static final String DELIMITER = ",";
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        this.lottoNumbers = sortLotto(lottoNumbers);
    }

    public Lotto(Integer... numbers) {
        List<LottoNumber> lotto = Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        checkLottoSize(lotto);
        this.lottoNumbers = sortLotto(lotto);
    }

    public Lotto(String lottoNumbers) {
        List<LottoNumber> lotto = Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        checkLottoSize(lotto);
        checkDuplicate(lotto);
        this.lottoNumbers = sortLotto(lotto);
    }

    private List<LottoNumber> sortLotto(List<LottoNumber> lottoNumbers) {
        return Collections.unmodifiableList(lottoNumbers.stream()
                .sorted().collect(Collectors.toList()));
    }

    private void checkLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_ENOUGH_LOTTO_NUMBER.message());
        }
    }

    private void checkDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(NOT_ENOUGH_LOTTO_NUMBER_DUPLICATE.message());
        }
    }
    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public int match(Lotto lotto) {
        return lotto.lottoNumbers().stream()
                .filter(this.lottoNumbers::contains)
                .collect(Collectors.toList()).size();
    }

    public boolean matchNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.stream().map(LottoNumber::toString)
                .collect(Collectors.joining(", ")));
    }
}

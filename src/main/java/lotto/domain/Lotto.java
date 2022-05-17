package lotto.domain;

import lotto.exceptions.DuplicatedNumbersException;
import lotto.exceptions.InvalidLottoByHandLengthException;
import lotto.util.Duplicated;

import java.util.*;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<LottoNumber> candidateNumbers = candidateNumbers();

        Collections.shuffle(candidateNumbers);
        this.lottoNumbers = candidateNumbers.subList(0, LOTTO_LENGTH);
        Collections.sort(this.lottoNumbers);
    }

    public Lotto(int[] lottoByHand) {
        if (Duplicated.hasDuplicatedNumber(lottoByHand)) {
            throw new DuplicatedNumbersException();
        }
        if (lottoByHand.length != LOTTO_LENGTH) {
            throw new InvalidLottoByHandLengthException();
        }
        this.lottoNumbers = parseIntegerArrayToLotto(lottoByHand);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (Duplicated.hasDuplicatedNumber(lottoNumbers)) {
            throw new DuplicatedNumbersException();
        }
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new InvalidLottoByHandLengthException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String[] lottoByHand) {
        if (Duplicated.hasDuplicatedNumber(lottoByHand)) {
            throw new DuplicatedNumbersException();
        }
        if (lottoByHand.length != LOTTO_LENGTH) {
            throw new InvalidLottoByHandLengthException();
        }
        this.lottoNumbers = parseStringArrayToLotto(lottoByHand);
    }

    private List<LottoNumber> candidateNumbers() {
        List<LottoNumber> candidateNumbers = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            candidateNumbers.add(LottoNumber.of(number));
        }
        return candidateNumbers;
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean hasNumbers(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private List<LottoNumber> parseStringArrayToLotto(String[] stringInputs) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String input : stringInputs) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(input)));
        }
        return lottoNumbers;
    }

    private List<LottoNumber> parseIntegerArrayToLotto(int[] inputs) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int input : inputs) {
            lottoNumbers.add(LottoNumber.of(input));
        }

        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return lottoNumbers != null ? lottoNumbers.equals(lotto.lottoNumbers) : lotto.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}

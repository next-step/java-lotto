package lotto.domain;

import java.security.InvalidParameterException;
import java.util.*;

public class Lotto {
    private final SortedSet<Integer> lottoNumbers;

    public Lotto() {
        this(LottoNumberGenerator.generateNumbers());
    }

    public Lotto(String numbers) {
        lottoNumbers = generateLotto(numbers);
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = new TreeSet<>(numbers);
    }

    private SortedSet<Integer> generateLotto(String numbers) {
        numbers = preprocessingData(numbers);
        SortedSet<Integer> lottoNumberSet = createLottoNumberSet(numbers);

        if (lottoNumberSet.size() < 6) {
            throw new InvalidParameterException("중복된 번호로 로또가 생성되려 하고 있습니다.");
        }

        return lottoNumberSet;
    }

    private SortedSet<Integer> createLottoNumberSet(String numbers) {
        SortedSet<Integer> lottos = new TreeSet<>();

        for (String number : numbers.split(",")) {
            lottos.add(parseInt(number));
        }
        return lottos;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private String preprocessingData(String numbers) {
        return numbers.replaceAll(" ", "");
    }

    public LottoResult getResult(Lotto winningLotto) {
        int matchCount = (int) lottoNumbers.stream().filter(w->winningLotto.contains(w)).count();
        return LottoResult.values()[matchCount];
    }

    private boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        for (int number : lottoNumbers) {
            result.add("" + number);
        }
        return String.join(",", result);
    }
}

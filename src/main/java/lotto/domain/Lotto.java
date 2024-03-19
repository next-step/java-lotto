package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private static final int RANDOM_BOUND_NUMBER = 45;
    private static final Random RANDOM = new Random();
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = createLottoNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new ArrayList<>();
        numbers.forEach(number -> this.lottoNumbers.add(new LottoNumber(number)));
    }

    public Lotto(String numbers) {
        List<String> splitNumbers = List.of(numbers.split(","));
        this.lottoNumbers = new ArrayList<>();
        splitNumbers.forEach(number -> this.lottoNumbers.add(new LottoNumber(Integer.parseInt(number))));
    }

    private static List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            addLottoNumber(newLottoNumbers);
        }
        return newLottoNumbers;
    }

    private static void addLottoNumber(List<LottoNumber> lottoNumbers) {
        LottoNumber newLottoNumber = new LottoNumber(RANDOM.nextInt(RANDOM_BOUND_NUMBER) + 1);

        if (validateDuplicateNumber(lottoNumbers, newLottoNumber)) {
            addLottoNumber(lottoNumbers);
            return;
        }

        lottoNumbers.add(newLottoNumber);
    }

    private static boolean validateDuplicateNumber(final List<LottoNumber> newLottoNumbers, final LottoNumber newLottoNumber) {
        return newLottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.getValue() == newLottoNumber.getValue())
                .count() > 0;
    }

    public int getNumberSize() {
        return lottoNumbers.size();
    }

    public int compareWinNumber(Lotto winNumber) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winNumber.contains(lottoNumber))
                .count();
    }

    public String getNumbersToString() {
        List<Integer> arrayList = new ArrayList<>();
        lottoNumbers.forEach(lottoNumber -> arrayList.add(lottoNumber.getValue()));
        return arrayList.toString();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }
}

package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int RANDOM_BOUND_NUMBER = 45;
    private static final Random RANDOM = new Random();
    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto() {
        this.lottoNumbers = createLottoNumbers();
    }

    public Lotto(List<Integer> numbers) {
        numbers.forEach(number -> this.lottoNumbers.add(new LottoNumber(number)));
    }

    public Lotto(String numbers) {
        List<String> splitNumbers = List.of(numbers.split(","));
        splitNumbers.forEach(number -> this.lottoNumbers.add(new LottoNumber(Integer.parseInt(number))));
    }

    private static Set<LottoNumber> createLottoNumbers() {
        Set<LottoNumber> newLottoNumbers = new HashSet<>();
        while (newLottoNumbers.size() < 6) {
            addLottoNumber(newLottoNumbers);
        }
        return newLottoNumbers;
    }

    private static void addLottoNumber(Set<LottoNumber> lottoNumbers) {
        LottoNumber newLottoNumber = new LottoNumber(RANDOM.nextInt(RANDOM_BOUND_NUMBER) + 1);
        lottoNumbers.add(newLottoNumber);
    }


    public int getNumberSize() {
        return lottoNumbers.size();
    }

    public AmountEnum compareWinNumber(Lotto winNumber) {
        int count = (int) lottoNumbers.stream()
                .filter(lottoNumber -> winNumber.contains(lottoNumber))
                .count();
        return AmountEnum.from(count);
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

package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int RANDOM_BOUND_NUMBER = 45;
    private static final Random RANDOM = new Random();
    private Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();

    public Lotto() {
        this.lottoNumbers = createLottoNumbers();
    }

    public Lotto(String numbers) {
        List<String> splitNumbers = List.of(numbers.split(","));
        validateDuplicate(splitNumbers);
        splitNumbers.forEach(number -> this.lottoNumbers.add(new LottoNumber(Integer.parseInt(number))));
    }

    private void validateDuplicate(final List<String> splitNumbers) {
        Set<String> set = new HashSet<>(splitNumbers);
        if (set.size() != splitNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
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

    public AmountEnum getAmountEnumCompareWinNumber(Lotto winNumber, LottoNumber bonusNumber) {
        int count = (int) lottoNumbers.stream()
                .filter(lottoNumber -> winNumber.contains(lottoNumber))
                .count();
        validateBonusNumber(winNumber, bonusNumber);
        boolean isBonusNumber = isBonusNumberExist(bonusNumber);
        return AmountEnum.from(count, isBonusNumber);
    }

    private void validateBonusNumber(Lotto winNumber, LottoNumber bonusNumber) {
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복됩니다.");
        }
    }


    public String getNumbersToString() {
        List<Integer> arrayList = new ArrayList<>();
        lottoNumbers.forEach(lottoNumber -> arrayList.add(lottoNumber.getValue()));
        return arrayList.toString();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private boolean isBonusNumberExist(final LottoNumber bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }
}

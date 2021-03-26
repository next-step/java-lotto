package lotto.step2;

import java.util.*;

public class Lotto {
    private final static int MATCHED = 1;
    private final static int MISMATCHED = 0;
    private final static String ILLEGAL_LOTTO = "로또는 6개의 서로 다른 숫자로 만들어져야 합니다";
    private Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateLottoSize();
    }

    public Lotto(String[] numbers) {
        for(String number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        validateLottoSize();
    }

    private void validateLottoSize(){
        if(lottoNumbers.size() != 6){
            throw new IllegalArgumentException(ILLEGAL_LOTTO);
        }
    }

    public int match(Lotto winningNumbers) {
        int matchCount = lottoNumbers.stream()
                .mapToInt(number -> winningNumbers.lottoNumbers.contains(number) ? MATCHED : MISMATCHED)
                .sum();
        return matchCount;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Lotto otherLotto = (Lotto) other;
        return otherLotto.lottoNumbers
                        .stream()
                        .filter(lottoNumber -> !otherLotto.lottoNumbers.contains(lottoNumber))
                        .findAny()
                        .isPresent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

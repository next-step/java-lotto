package lotto.step2.domain;

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
        return lottoNumbers.stream()
                .mapToInt(number -> winningNumbers.lottoNumbers.contains(number) ? MATCHED : MISMATCHED)
                .sum();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

}

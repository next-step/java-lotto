package lottoauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> lottoNumbersCache = LottoNumber.rangedClosed().mapToObj(LottoNumber::from).collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE + "개의 로또 번호를 입력해야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private boolean isDuplicated(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream().distinct().count();
    }

    public static Lotto createAuto() {
        Collections.shuffle(lottoNumbersCache);
        List<LottoNumber> lottoNumbers = lottoNumbersCache.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(String[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(LottoNumber.from(number));
        }
        return new Lotto(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        for(LottoNumber number : lottoNumbers) {
            if(lottoNumber.equals(number))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
//        return "Lotto{" +
//                "lottoNumbers=" + lottoNumbers +
//                '}';
        return "" + lottoNumbers;
    }
}

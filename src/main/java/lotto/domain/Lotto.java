package lotto.domain;

import java.util.*;

public class Lotto {
    private final int LOTTO_SIZE = 6;
    private Set<LottoNo> lottoNumbers;

    private Lotto(Set<LottoNo> lottoNumbers) {
        if(lottoNumbers.size() > LOTTO_SIZE) throw new IllegalArgumentException();
        this.lottoNumbers = lottoNumbers;
    }

    /** 정적 팩토리메서드 */
    public static Lotto from(List<Integer> numbers) {
        Set<LottoNo> lotto = new HashSet<>();
        for(Integer i : numbers) {
            lotto.add(LottoNo.of(i));
        }
        return new Lotto(lotto);
    }

    public static Lotto fromComma(String value) {
        String[] values = value.split(",");
        Set<LottoNo> lotto = new HashSet<>();
        for (String v : values) {
            lotto.add(LottoNo.of(Integer.parseInt(v)));
        }
        return new Lotto(lotto);
    }

    int match(Lotto lotto) {
        int count = 0;
        for(LottoNo lottoNumber : lottoNumbers) {
            count += lotto.addCount(lottoNumber);
        }
        return count;
    }

    int addCount(LottoNo lottoNumber) {
        if(contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean contains(LottoNo pickNumber) {
        return lottoNumbers.contains(pickNumber);
    }

    public int size() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Lotto lotto = (Lotto) obj;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }
}

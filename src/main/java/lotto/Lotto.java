package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    /** 정적 팩토리메서드 */
    public static Lotto from(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public static Lotto fromComma(String value) {
        String[] values = value.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String v : values) {
            lotto.add(Integer.parseInt(v));
        }
        return new Lotto(lotto);
    }

    public String toString() {
        return String.join(", ", String.valueOf(lottoNumbers));
    }

    int match(Lotto lotto) {
        int count = 0;
        for(int lottoNumber : lottoNumbers) {
            count += lotto.addCount(lottoNumber);
        }
        return count;
    }

    int addCount(int lottoNumber) {
        if(contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean contains(int pickNumber) {
        return lottoNumbers.contains(pickNumber);
    }

    public int size() {
        return lottoNumbers.size();
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

package step2;

import java.util.*;

public class Lotto implements Iterable<LottoNumber>{
    private static final int LOTTO_NUM_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 총" + LOTTO_NUM_COUNT + "개 이어야 합니다.");
        };

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<Integer> nums) {
        List<LottoNumber> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                throw new IllegalArgumentException("로또 숫자는 중복이 불가능 합니다.");
            }

            list.add(new LottoNumber(num));
        }
        //정렬
        Collections.sort(list);
        return new Lotto(list);
    }

    public static Lotto create(int... nums) {
        List<LottoNumber> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                throw new IllegalArgumentException("로또 숫자는 중복이 불가능 합니다.");
            }
            
            list.add(new LottoNumber(num));
        }

        return new Lotto(list);
    }

    public boolean contains(LottoNumber lottoNumer) {
        return lottoNumbers.contains(lottoNumer);
    }

    public int getNumberCount() {
        return lottoNumbers.size();
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
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}

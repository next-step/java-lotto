package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> list) {
        this.lotto = validate(generateLotto(list));
    }

    private List<LottoNumber> generateLotto(List<Integer> list) {
        List<LottoNumber> lottoList = new ArrayList<>();

        for (Integer integer : list) {
            lottoList.add(new LottoNumber(integer));
        }
        return lottoList;
    }

    private List<LottoNumber> validate(List<LottoNumber> list) {
        if (list.size() == SIZE) {
            return list;
        }
        throw new InputMismatchException("로또 번호는 6자리를 입력해 주세요.");
    }

    public List<LottoNumber> find() {
        return Collections.unmodifiableList(lotto);
    }

    public LottoRank findRank(List<Integer> winList, int bonus) {
        if (isRank(winList)) {
            return LottoRank.findMatchCount(countMath(winList), contains(bonus));
        }
        return LottoRank.MISS;

    }

    public boolean contains(int bonus) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.same(bonus));
    }

    public int countMath(List<Integer> winList) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += lottoNumber.exist(winList);
        }
        return count;
    }

    private boolean isRank(List<Integer> winList) {
        return countMath(winList) > 2;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}

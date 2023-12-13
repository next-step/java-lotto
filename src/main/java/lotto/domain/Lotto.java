package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lotto;
    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lotto = new ArrayList<>(createToLottoNumbers(lottoNumbers));
    }
    public int match(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count = getCount(winningLotto, count, lottoNumber);
        }
        return count;
    }

    public Boolean matchBonus(int bonusNo) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(new LottoNumber(bonusNo)));
    }

    private int getCount(Lotto winningLotto, int count, LottoNumber lottoNumber) {
        if (winningLotto.contains(lottoNumber)) {
            count++;
        }
        return count;
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 사이즈는 6이어야한다.");
        }
    }
    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumberList = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumberList.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 숫자를 가징 수 없습니다.");
        }
    }

    private static List<LottoNumber> createToLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lotto + "";
    }

}

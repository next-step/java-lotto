package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_NUM_COUNT = 6;

    private final Set<LottoNumber> winningLottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(Set<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
        if (winningLottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 총" + LOTTO_NUM_COUNT + "개 이어야 합니다.");
        }

        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(String nums, String bonusNumber) {
        LottoNumber bonusLottoNumber = LottoNumber.of(Integer.parseInt(bonusNumber));

        Set<LottoNumber> lottoNumbers = Arrays.asList(nums.split(",")).stream()
                .map(value -> Integer.parseInt(value.trim()))
                .map(value -> LottoNumber.of(value))
                .collect(Collectors.toCollection(TreeSet::new));

        if (lottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복이 되어선 안됩니다.");
        }

        return new WinningLotto(lottoNumbers, bonusLottoNumber);
    }


    public int matchNumber(Set<LottoNumber> lotto) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : lotto) {
            if (winningLottoNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean matchBonusNumber(Set<LottoNumber> lotto) {
        return lotto.contains(bonusNumber);
    }
}

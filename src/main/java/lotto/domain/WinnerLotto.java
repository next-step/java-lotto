package lotto.domain;

import java.util.List;

public class WinnerLotto {
    // extends keyword 제거됨
    private final LottoNumber bonusBall;
    private final Lotto winnersLotto;
    public WinnerLotto(LottoNumber bonusBall, Lotto winnersLotto) {

        checkLottoContainsBonusball(bonusBall, winnersLotto.getNumbers());
        this.winnersLotto = winnersLotto;
        this.bonusBall = bonusBall;
    }

    public List<LottoNumber> getNumbers() {
        return winnersLotto.getNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private void checkLottoContainsBonusball (LottoNumber bonusBalla, List<LottoNumber> numbers) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스번호가 로또번호와 중복됩니다.");
        }
    }

    public static WinnerLotto of (LottoNumber bonusBall, List<LottoNumber> numbers) {
        return new WinnerLotto(bonusBall, Lotto.of(numbers));
    }

    private boolean contains(LottoNumber lottoNumber) {
        return getNumbers().contains(lottoNumber);
    }

    public int getMatchedCount(List<LottoNumber> lottoNumber) {
        return (int) lottoNumber.stream().filter(this::contains).count();
    }
    public Prize getPrizeForEachLotto(List<LottoNumber> lottoNumber) {
        int matchCnt = getMatchedCount(lottoNumber);
        // DONE : 5개+보너스볼1개 인 경우의 분기 처리 구현
        return Prize.getPrizeByMatchedNumber(matchCnt,lottoNumber, bonusBall);
    }


}

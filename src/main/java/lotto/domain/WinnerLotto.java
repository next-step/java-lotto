package lotto.domain;

import java.util.List;

public class WinnerLotto {
    // extends keyword 제거됨
    private final LottoNumber bonusBall;
//    private final List<LottoNumber> numbers;
    private final PlayersLotto playersLotto;
    public WinnerLotto(LottoNumber bonusBall, PlayersLotto playersLotto) {

        checkLottoContainsBonusball(bonusBall,playersLotto.getNumbers());
        this.playersLotto = playersLotto;
        this.bonusBall = bonusBall;
//        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return playersLotto.getNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private void checkLottoContainsBonusball (LottoNumber bonusBall, List<LottoNumber> numbers) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스번호가 로또번호와 중복됩니다.");
        }
    }

    public static WinnerLotto of (LottoNumber bonusBall, List<LottoNumber> numbers) {
        return new WinnerLotto(bonusBall,PlayersLotto.of(numbers));
    }

    public int getMatchedCount(List<LottoNumber> lottoNumber) {
        // DONE: 5개 적중 시 보너스 볼을 추가 검증해서 적중수가 5+1지(보너스볼)인지, 6인지를 구분짓는 로직이 필요함.
        // 여기에서는 갯수만 카운팅 하고 보너스 볼에 대한 로직은 getPrizeForEachLotto 에서 검증하는 것이 맞는것 같아 수정해 보았습니다.
        int matchedCount = (int) lottoNumber.stream()
                .filter(this.playersLotto.getNumbers()::contains)
                .count();
        return matchedCount;
    }
    public Prize getPrizeForEachLotto(List<LottoNumber> lottoNumber) {
        int matchCnt = getMatchedCount(lottoNumber);
        // DONE : 5개+보너스볼1개 인 경우의 분기 처리 구현

        return Prize.getPrizeByMatchedNumber(matchCnt,lottoNumber, bonusBall);
    }


}

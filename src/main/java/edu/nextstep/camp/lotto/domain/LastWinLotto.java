package edu.nextstep.camp.lotto.domain;

import java.util.Arrays;

public class LastWinLotto {

    private final Lotto lastWinLotto;

    private final LottoNumber bonusNumber;

    private LastWinLotto(Lotto lastWinLotto, LottoNumber bonusNumber) {
        this.lastWinLotto = lastWinLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LastWinLotto of(String bonusNumber, String[] lottoNumbers) {
        return of(Integer.parseInt(bonusNumber), Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .toArray(Integer[]::new)
        );
    }

    public static LastWinLotto of(Integer bonusNumber, Integer[] lottoNumbers) {
        duplicateBonusNumberCheck(bonusNumber, lottoNumbers);

        return new LastWinLotto(new Lotto(lottoNumbers), new LottoNumber(bonusNumber));
    }

    public LottoRank checkRank(Lotto lotto) {
        return LottoRank.valueOf(lotto.matchNumberCount(lastWinLotto), lotto.isMatchBonus(bonusNumber));
    }

    private static void duplicateBonusNumberCheck(Integer bonusNumber, Integer[] beforeLottoNums) {
        for (Integer beforeLottoNum : beforeLottoNums) {
            numberEqualsCheck(bonusNumber, beforeLottoNum);
        }
    }

    private static void numberEqualsCheck(Integer bonusNumber, Integer beforeLottoNum) {
        if (beforeLottoNum.equals(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 지난주 로또 번호와 겹칠 수 없습니다.");
        }
    }
}

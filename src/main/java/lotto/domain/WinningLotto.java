package lotto.domain;

public class WinningLotto {

    private final Lotto lastWeekLotto;

    private final LottoNumber bonusBall;

    public WinningLotto(Lotto lastWeekLotto, LottoNumber bonusBall) {
        validation(lastWeekLotto, bonusBall);
        this.lastWeekLotto = lastWeekLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusBall) {
        return new WinningLotto(lotto, bonusBall);
    }

    private void validation(Lotto lastWeekLotto, LottoNumber bonusBall) {
        if(lastWeekLotto.contains(bonusBall)){
            throw new IllegalArgumentException(" 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

    public int compare(Lotto lotto) {
        return lastWeekLotto.matchCount(lotto);
    }

    public boolean compareBonus(Lotto lotto) {
        if ( 5 == compare(lotto)){
            return lotto.lottoNumbers().stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
        }
        return false;
    }
}

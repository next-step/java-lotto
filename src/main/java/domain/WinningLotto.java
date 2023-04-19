package domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;
    public WinningLotto(final Lotto lotto, final LottoNumber bonusNumber){
        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될수 없습니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int match(final Lotto lotto){
        int matchCount = lotto.match(this.lotto);
        boolean matchBonus = lotto.contains(bonusNumber);
        return Rank.of(matchCount, matchBonus);
    }
}

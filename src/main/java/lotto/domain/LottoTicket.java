package lotto.domain;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this(new LottoNumbers());
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank getRank(WinLotto winLotto) {
        int matchCount = count(winLotto.getWinLotto());
        boolean matchBonus = isMatchBonus(winLotto.getBonusNumber());
        return Rank.valueOf(matchCount, matchBonus);
    }

    private boolean isMatchBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int count(LottoTicket winLotto) {
        return (int) winLotto.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public LottoNumbers get() {
        return this.lottoNumbers;
    }

    public boolean contains(LottoNumber number) {
        return this.lottoNumbers.contains(number);
    }

}

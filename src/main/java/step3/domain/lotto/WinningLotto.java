package step3.domain.lotto;

public class WinningLotto {

    private final LottoNumber lottoNumber;
    private final int bonusNumber;

    public WinningLotto(LottoNumber lottoNumber, int bonusNumber) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoNumber winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public int findCountOfMatch(LottoNumber lottoNumber) {
        return (int) this.lottoNumber.getNumbers()
                .stream()
                .filter(number -> isContains(lottoNumber, number))
                .count();
    }

    private static boolean isContains(LottoNumber lottoNumber, Integer number) {
        return lottoNumber.hasNumber(number);
    }
}

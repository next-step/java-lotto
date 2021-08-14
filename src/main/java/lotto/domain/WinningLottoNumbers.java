package lotto.domain;

public class WinningLottoNumbers {

    private static final String DUPLICATED_LOTTO_NUMBER_EXCEPTION_MESSAGE_FORMAT = "중복되는 당첨 번호가 존재합니다. bonusBall: %s";

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusBall;

    private WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        this.winningLottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningLottoNumbers of(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        validateDuplicateLottoNumber(lottoNumbers, bonusBall);
        return new WinningLottoNumbers(lottoNumbers, bonusBall);
    }

    private static void validateDuplicateLottoNumber(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        if (lottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(String.format(DUPLICATED_LOTTO_NUMBER_EXCEPTION_MESSAGE_FORMAT, bonusBall));
        }
    }

    public Rank match(LottoNumbers lottoNumbers) {
        int countOfMatch = winningLottoNumbers.countOfMatch(lottoNumbers);
        boolean hitBonusBall = lottoNumbers.contains(bonusBall);
        return Rank.valueOf(countOfMatch, hitBonusBall);
    }
}

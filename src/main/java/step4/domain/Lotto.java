package step4.domain;

/**
 * 로또 엔터티 : 하나의 로또 티켓
 * 내부에 정확히 하나의 LottoNumbers만 보유, 가격 가지고 있지 않음
 * 행위 : match(당첨번호와 비교해 MatchResult 만듬)
 */
public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    /**
     * 팩토리 메서드
     */
    public static Lotto ofAuto() {
        return new Lotto(LottoNumbers.ofAuto());
    }

    public static Lotto ofManual(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofManual(String number) {
        return new Lotto(LottoNumbers.ofManual(number));
    }

    //당첨 결과와 비교해서 MatchResult 반환
    public MatchResult match(LottoNumbers otherNumbers, int bonusNumber) {
        int match = lottoNumbers.matchCount(otherNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return new MatchResult(match, bonusMatch);
    }

    public String numbersToString() {
        return lottoNumbers.numbers()
            .toString();
    }
}

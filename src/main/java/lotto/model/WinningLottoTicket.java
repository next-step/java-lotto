package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket extends LottoTicket {

    private final LottoNumber bonusLottoNumber;

    public WinningLottoTicket(List<LottoNumber> numbers, LottoNumber bonusLottoNumber) {
        super(numbers);

        validateDuplicateBonusLottoNumber(numbers, bonusLottoNumber);

        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validateDuplicateBonusLottoNumber(List<LottoNumber> numbers, LottoNumber bonusLottoNumber) {
        if (numbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다. - " + bonusLottoNumber);
        }
    }

    public static WinningLottoTicket createBy(List<Integer> numbers, LottoNumber bonusLottoNumber) {
        List<LottoNumber> LottoNumbers = numbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

        return new WinningLottoTicket(LottoNumbers, bonusLottoNumber);
    }

    public LottoResults match(PurchasedLottoTickets purchasedLottoTickets) {
        List<LottoResult> lottoResults = purchasedLottoTickets.getPurchasedLottoTickets()
            .stream()
            .map(this::matchWinningLotto)
            .collect(Collectors.toList());

        return LottoResults.of(lottoResults);
    }

    private LottoResult matchWinningLotto(PurchasedLottoTicket purchasedLottoTicket) {
        long count = getMatchCount(purchasedLottoTicket);
        boolean isMatchLottoBonusNumber = isMatchLottoBonusNumber(purchasedLottoTicket);

        return LottoResult.of(LottoMatchCount.of(Math.toIntExact(count), isMatchLottoBonusNumber));
    }

    private long getMatchCount(PurchasedLottoTicket purchasedLottoTicket) {
        return purchasedLottoTicket.getNumbers()
            .stream()
            .filter(purchasedLottoNumber -> numbers.contains(purchasedLottoNumber))
            .count();
    }

    private boolean isMatchLottoBonusNumber(PurchasedLottoTicket purchasedLottoTicket) {
        return purchasedLottoTicket.getNumbers().contains(this.bonusLottoNumber);
    }
}

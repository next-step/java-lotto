package lotto.lotto;

import java.util.List;

import lotto.error.ErrorMessage;
import lotto.shop.NumberGenerator;

public class LottoTicket {
    private final List<Lotto> lottoTickets;

    public LottoTicket(List<Lotto> selfLottoList, int autoLottoQuantity) {
        lottoTickets = selfLottoList;
        selectAuto(autoLottoQuantity);
    }

    public List<Lotto> tickets() {
        return lottoTickets;
    }

    public LottoResult matchWinningNumber(WinningNumber winningNumber, LottoNumber bonusNumber) {
        checkDuplicateBonusNumber(winningNumber, bonusNumber);
        LottoResult lottoResult = new LottoResult();
        lottoTickets.forEach(lotto -> lottoResult.increaseCount(lotto.matchingCount(winningNumber), lotto.isContainBonus(bonusNumber)));
        return lottoResult;
    }

    public int matchingCount() {
        return lottoTickets.size();
    }

    private void checkDuplicateBonusNumber(WinningNumber winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    private void selectAuto(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(createAutoLotto());
        }
    }

    private Lotto createAutoLotto() {
        return generateNumber();
    }

    private Lotto generateNumber() {
        return new Lotto(NumberGenerator.generate());
    }
}

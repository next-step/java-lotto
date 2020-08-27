package lotto.domain;

import lotto.utils.LottoValidationUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.*;

public class LottoTicket {

    private List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
        LottoValidationUtils.validateLottoNumberRange(lottoTicket);
        LottoValidationUtils.validateLottoNumberSizeToSix(lottoTicket);
        LottoValidationUtils.validateLottoNumberDuplication(lottoTicket);
    }

    public Rank matchRank(final WinningNumber winningNumber) {
        int matchCount = getMatchCount(winningNumber.getWinningNumber());
        boolean hasBonusNumber = isBonusNumber(winningNumber, matchCount);

        return Rank.valudOf(matchCount, hasBonusNumber);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return IntStream.range(NUMBER_ZERO, lottoTicket.size())
                .map(number -> getContainsLottoNumber(winningNumbers, number))
                .sum();
    }

    private int getContainsLottoNumber(List<Integer> winningNumbers, int number) {
        return winningNumbers.contains(getLottoTicketNumber(number)) ? NUMBER_ONE : NUMBER_ZERO;
    }

    private boolean isBonusNumber(WinningNumber winningNumber, int matchCount) {
        if (matchCount == NUMBER_FIVE) {
            return winningNumber.isContainsBonusNumber();
        }
        return false;
    }

    public List<Integer> getLottoTicket() {
        return Collections.unmodifiableList(this.lottoTicket);
    }

    public Integer getLottoTicketNumber(int index) {
        return lottoTicket.get(index);
    }

    public int size() {
        return lottoTicket.size();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTicket);
    }

}

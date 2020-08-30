package lotto.domain;

import lotto.utils.LottoValidationUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

import static lotto.utils.CommonConstant.NUMBER_FIVE;
import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class LottoTicket {

    private List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
        LottoValidationUtils.validateLottoNumberRange(lottoTicket);
        LottoValidationUtils.validateLottoNumberSizeToSix(lottoTicket);
        LottoValidationUtils.validateNumberDuplication(lottoTicket);
    }

    public Rank matchRank(final WinningNumber winningNumber) {
        long matchCount = getMatchCount(winningNumber);
        boolean hasBonusNumber = isSecondRank(winningNumber, matchCount);

        return Rank.valudOf(matchCount, hasBonusNumber);
    }

    public long getMatchCount(final WinningNumber winningNumbers) {
        return LongStream.range(NUMBER_ZERO, lottoTicket.size())
                .map(number -> getContainsLottoNumber(winningNumbers, number))
                .sum();
    }

    private long getContainsLottoNumber(final WinningNumber winningNumbers, long number) {
        return winningNumbers.isContainsLottoNumber(getLottoTicketNumber((int) number)) ? new Count(NUMBER_ZERO).update() : new Count(NUMBER_ZERO).getCount();
    }

    private boolean isSecondRank(final WinningNumber winningNumber, long matchCount) {
        return (matchCount == NUMBER_FIVE) && isContainsBonusNumber(winningNumber);
    }

    public boolean isContainsBonusNumber(final WinningNumber winningNumber) {
        return lottoTicket.contains(winningNumber.getBonusNumber());
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

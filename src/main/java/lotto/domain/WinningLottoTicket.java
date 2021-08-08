package lotto.domain;

import lotto.LottoRank;

import java.util.*;
import java.util.stream.Collectors;

public class WinningLottoTicket {
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String SPLIT_CUSTOM_REGEX = ",|, | ,";

    private final Set<LottoNumber> winningLottoTicket;
    private final LottoNumber bonusLottoNumber;

    private WinningLottoTicket(List<Integer> winningLottoNumberList, LottoNumber bonusLottoNumber) {
        this.winningLottoTicket = makeWinningLottoTicket(winningLottoNumberList);

        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLottoTicket of(List<Integer> winningLottoNumberList, LottoNumber bonusLottoNumber) {
        return new WinningLottoTicket(winningLottoNumberList, bonusLottoNumber);
    }

    private Set<LottoNumber> makeWinningLottoTicket(List<Integer> winningLottoNumberList) {
        return winningLottoNumberList.stream()
                .map(winningLottoNumber -> LottoNumber.of(winningLottoNumber))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public int getCountOfMatch(LottoTicket lottoTicket) {
        return (int) winningLottoTicket.stream()
                .filter(lottoNumber -> lottoTicket.contains(lottoNumber))
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLottoTicket.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoTicket that = (WinningLottoTicket) o;
        return winningLottoTicket.equals(that.winningLottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoTicket);
    }

    public LottoRank match(LottoTicket lottoTicket) {
        int countOfMatch = getCountOfMatch(lottoTicket);
        boolean bonusMatch = lottoTicket.contains(bonusLottoNumber);

        return LottoRank.valueOf(countOfMatch, bonusMatch);
    }
}

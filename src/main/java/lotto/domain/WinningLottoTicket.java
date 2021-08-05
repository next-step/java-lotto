package lotto.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningLottoTicket {
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String SPLIT_CUSTOM_REGEX = ",|, | ,";

    private final Set<LottoNumber> winningLottoTicket;

    private WinningLottoTicket(String winningLottoTicketString) {
        String trimWinningNumberString = replaceBlank(winningLottoTicketString);

        this.winningLottoTicket = makeWinningLottoTicketByString(trimWinningNumberString);
    }

    public static WinningLottoTicket of(String winningLottoTicketString) {
        return new WinningLottoTicket(winningLottoTicketString);
    }

    private Set<LottoNumber> makeWinningLottoTicketByString(String trimWinningNumberString) {
        return Arrays.stream(trimWinningNumberString.split(SPLIT_CUSTOM_REGEX))
                .map(number -> LottoNumber.of(Integer.parseInt(number)))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private String replaceBlank(String LottoNumbers) {
        String trimWinningNumberString = LottoNumbers.replace(SPACE, BLANK);
        return trimWinningNumberString;
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
}

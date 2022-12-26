package lotto.domain;

import lotto.strategy.LottoAutoStrategy;
import lotto.strategy.LottoMakeStrategy;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBER_FIX_SIZE = 6;
    private static final String LOTTO_NUMBER_FIX_MESSAGE = "로또 개수가 맞지않습니다";

    private final Set<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoNumbers){
        validationLottoTicketSizeCheck(lottoNumbers);
        this.lottoTicket = toSetLottoNumbers(lottoNumbers);
    }

    public LottoTicket(LottoMakeStrategy lottoMakeStrategy) {
        this(lottoMakeStrategy.valueOf());
    }

    public LottoTicket(int... numbers){
        this(toLottoTickets(numbers));
    }

    private Set<LottoNumber> toSetLottoNumbers(List<LottoNumber> lottoNumbers){
        return new HashSet<>(lottoNumbers);
    }

    public static List<LottoNumber> toLottoTickets(int... numbers){
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public Reward lottoNumberMatch(WinningNumbers winningNumbers){
        return winningNumbers.winningLottoMatch(lottoTicket);
    }

    private void validationLottoTicketSizeCheck(List<LottoNumber> numbers){
        if(numbers.size() != LOTTO_NUMBER_FIX_SIZE){
            throw new IllegalArgumentException(LOTTO_NUMBER_FIX_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }

    public Set<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}

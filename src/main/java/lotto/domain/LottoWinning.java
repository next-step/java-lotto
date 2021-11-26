package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoWinning {

    private static final int LOTTO_SIZE = 6;

    private final Lotto winningNumbers;

    private LottoWinning(List<Integer> winningNumbers) {

        this.winningNumbers = Lotto.winningFrom(winningNumbers);

    }

    public static LottoWinning from(List<Integer> winningNumbers) {

        if(winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨번호는 6자리 입니다!!!!");
        }

        return new LottoWinning(winningNumbers);
    }

    public Map<Integer, Integer> createRepository(LottoTicket lottoTicket) {
        return lottoTicket.createRepository(winningNumbers);
    }

    public double calculateRateOfProfit(LottoTicket lottoTicket, int orderPrice) {
        return lottoTicket.calculateRateOfProfit(winningNumbers, orderPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinning that = (LottoWinning) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}

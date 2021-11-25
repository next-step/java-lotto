package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LottoTicket {

    private static final String RATE_PATTERN = "0.##";

    private List<Lotto> lottoNumbers = new ArrayList<>();

    public LottoTicket(int orderCount) {

        createAutoTicket(orderCount);

    }

    private LottoTicket(List<Lotto> lottoNumber) {

        this.lottoNumbers = lottoNumber;
    }

    public static LottoTicket from(List<Lotto> lottoNumber) {
        return new LottoTicket(lottoNumber);
    }

    private void createAutoTicket(int orderCount) {
        for(int i = 0; i < orderCount; i ++) {
            lottoNumbers.add(new Lotto());
        }
    }

    public int totalCountOfMatch(Lotto winningNumbers, int count) {
        return (int) lottoNumbers.stream()
                .filter(lotto -> lotto.countOfMatch(winningNumbers, count))
                .count();
    }

    public Map<Integer, Integer> createRepository(Lotto winningNumbers) {
        Map<Integer, Integer> repository = new HashMap<>();
        for (Rank rank : Rank.values()) {
            repository.put(rank.getCountOfMatch(), totalCountOfMatch(winningNumbers, rank.getCountOfMatch()));
        }
        return repository;
    }

    public double calculateRateOfProfit(Lotto winningNumbers, int orderPrice) {
        double totalPrizeMoney = totalPrizeMoney(winningNumbers);

        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);

        return Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
    }

    private int totalPrizeMoney(Lotto winningNumbers) {
        return lottoNumbers.stream()
                .mapToInt(lotto -> lotto.calculatePrizeMoney(winningNumbers))
                .sum();
    }

    public List<Lotto> getLotto() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}

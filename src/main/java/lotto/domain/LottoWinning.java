package lotto.domain;

import lotto.domain.value.LottoNumber;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoWinning {

    private static final int LOTTO_SIZE = 6;

    private static final String FORM_ERROR_MSG = "당첨번호는 6자리 입니다!!!!";
    private static final String NUMBER_CHECK_ERROR_MSG = "숫자만 입력 가능합니다!!!!";
    private static final String RATE_PATTERN = "0.##";

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    private LottoWinning(List<Integer> winningNumbers, int bonusBall) {

        this.winningNumbers = Lotto.winningFrom(winningNumbers);
        this.bonusBall = new LottoNumber(bonusBall);

    }

    public static LottoWinning from(List<Integer> winningNumbers, String bonusBall) {

        if(winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(FORM_ERROR_MSG);
        }
        constantCheck(bonusBall);
        if (winningNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨번호에 있는 번호는 보너스 번호가 아닙니다!!!");
        }

        return new LottoWinning(winningNumbers, Integer.parseInt(bonusBall));
    }

    public Map<Rank, Integer> createRepository(LottoTicket lottoTicket) {

        Map<Rank, Integer> repository = new EnumMap(Rank.class);

        for (Lotto lotto : lottoTicket.getLotto()) {
            Rank rank = Rank.valueOf(lotto.countOfMatch(winningNumbers), lotto.contains(bonusBall));
            repository.put(rank, repository.getOrDefault(rank, 0) + 1);
        }

        return repository;
    }

    public double calculateRateOfProfit(Map<Rank, Integer> prizeWinnersRepository, int orderPrice) {
        double totalPrizeMoney = totalPrizeMoney(prizeWinnersRepository);

        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);

        return Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
    }

    private int totalPrizeMoney(Map<Rank, Integer> prizeWinnersRepository) {
        return prizeWinnersRepository.keySet().stream()
                .mapToInt(rank -> rank.getPrizeMoney() * prizeWinnersRepository.get(rank))
                .sum();
    }

    private static void constantCheck(String orderPrice) {

        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NUMBER_CHECK_ERROR_MSG);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoWinning that = (LottoWinning) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}

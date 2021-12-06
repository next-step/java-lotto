package lotto.domain;

import lotto.domain.value.LottoNumber;
import lotto.service.util.DigitCheckStrategy;
import lotto.service.util.SizeCheckStrategy;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoWinning implements SizeCheckStrategy, DigitCheckStrategy {

    private static final int PLUS_COUNT = 1;

    private static final String RATE_PATTERN = "0.##";
    private static final String BONUS_BALL_ERROR_MSG = "당첨번호에 있는 번호는 보너스 번호가 아닙니다!!!";

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    private LottoWinning(List<Integer> winningNumbers, String bonusBall) {

        if(isSizeOverCheck(winningNumbers.size())) {
            throw new IllegalArgumentException(FORM_ERROR_MSG);
        }

        if(!isDigitCheck(bonusBall)) {
            throw new IllegalArgumentException(NUMBER_CHECK_ERROR_MSG);
        }

        if (winningNumbers.contains(Integer.parseInt(bonusBall))) {
            throw new IllegalArgumentException(BONUS_BALL_ERROR_MSG);
        }

        this.winningNumbers = Lotto.manualFrom(winningNumbers);
        this.bonusBall = new LottoNumber(Integer.parseInt(bonusBall));

    }

    public static LottoWinning from(List<Integer> winningNumbers, String bonusBall) {
        return new LottoWinning(winningNumbers, bonusBall);
    }

    public Map<Rank, Integer> createRepository(LottoTicket lottoTicket) {

        Map<Rank, Integer> repository = new EnumMap(Rank.class);

        for (Lotto lotto : lottoTicket.getLotto()) {
            Rank rank = Rank.valueOf(lotto.countOfMatch(winningNumbers), lotto.contains(bonusBall));
            repository.merge(rank, PLUS_COUNT, (value1, value2) -> value1 + value2);
        }

        return repository;
    }

    public double calculateRateOfProfit(Map<Rank, Integer> prizeWinnersRepository, int orderPrice) {
        double totalPrizeMoney = totalPrizeMoney(prizeWinnersRepository);

        DecimalFormat decimalFormat = new DecimalFormat(RATE_PATTERN);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        return Double.parseDouble(decimalFormat.format(totalPrizeMoney / orderPrice));
    }

    private int totalPrizeMoney(Map<Rank, Integer> prizeWinnersRepository) {
        return prizeWinnersRepository.keySet().stream()
                .mapToInt(rank -> rank.getPrizeMoney() * prizeWinnersRepository.get(rank))
                .sum();
    }

    @Override
    public boolean isSizeOverCheck(int lottoSize) {
        return lottoSize != LOTTO_SIZE;
    }

    @Override
    public boolean isDigitCheck(String bonusBall) {

        for (char c : bonusBall.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
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

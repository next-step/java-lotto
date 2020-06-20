package step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoWinningNumbers {
    private static final int WINNING_NUMBER_COUNT_WITH_BONUS = 7;
    private static final int NOT_DUPLICATE_NUMBER_COUNT = 1;
    private final List<LottoNumber> winningNumbers;

    public LottoWinningNumbers(String stringWinningNumbers, int bonusNumber) {
        List<String> winningNumberList = Arrays.asList(stringWinningNumbers.split(","));

        this.winningNumbers = winningNumberList.stream()
                .map(winningNumber -> new LottoNumber(Integer.parseInt(winningNumber.trim())))
                .collect(Collectors.toList());

        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        bonusLottoNumber.setBonus(true);

        this.winningNumbers.add(bonusLottoNumber);
        validate();
    }

    public List<LottoResult> checkLottoWinning(List<LottoTicket> lottoTicketList) {
        return lottoTicketList.stream().map(this::compareLottoNumber).collect(Collectors.toList());
    }

    private LottoResult compareLottoNumber(LottoTicket lottoTicket) {
        List<LottoNumber> myWinningNumbers = winningNumbers.stream()
                .filter(lottoNumber -> lottoTicket.getNumbers().stream().anyMatch(lottoNumber::compareToNumber))
                .collect(Collectors.toList());
        boolean hasBonus = myWinningNumbers.stream().filter(LottoNumber::isBonus).count() == 1;
        int winningCount = myWinningNumbers.size() - (hasBonus ? 1 : 0);

        return new LottoResult(winningCount, hasBonus);
    }

    private void validate() {
        boolean isDuplicate = false;
        for (int i = 1; i < winningNumbers.size(); i++) {
            LottoNumber winningNumber = winningNumbers.get(i - 1);
            long count = winningNumbers.stream().filter(winningNumber::compareToNumber).count();

            isDuplicate = count > NOT_DUPLICATE_NUMBER_COUNT;
        }

        if (winningNumbers.size() != WINNING_NUMBER_COUNT_WITH_BONUS || isDuplicate) {
            throw new IllegalArgumentException();
        }
    }
}

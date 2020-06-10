package step2;

import java.util.List;

public class LottoResult {
    private static final int LOTTO_WINNING_NUMBER_COUNT = 6;
    private WinningNumbers winningNumbers = new WinningNumbers();
    private Statistics statistics = new Statistics();

    private LottoResult() {
    }

    public LottoResult(List<LottoTicket> lottoTicketList, String winningNumbers) {
        setWinningNumbers(winningNumbers.split(","));
        compareLottoNumbers(lottoTicketList);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    private void setWinningNumbers(String[] split) {
        if (split.length != LOTTO_WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("갯수를 맞춰주세요");
        }

        for (String number : split) {
            this.winningNumbers.addNumber(Integer.parseInt(number.trim()));
        }
    }

    private void compareLottoNumbers(List<LottoTicket> lottoTicketList) {
        for (LottoTicket lottoTicket : lottoTicketList) {
            setStatistics(lottoTicket.getNumbers());
        }
    }

    private void setStatistics(List<Integer> lottoNumberList) {
        statistics.addCount(winningNumbers.countingWinningNumbers(lottoNumberList));
    }
}

package step2;

import java.util.List;

public class LottoResult {
    private WinningNumbers winningNumbers = new WinningNumbers();
    private Statistics statistics = new Statistics();

    private LottoResult() {
    }

    public LottoResult(List<LotteryNumbers> lotteryNumbersList, String winningNumbers) {
        this();
        setWinningNumbers(winningNumbers.split(","));
        compareLottoNumbers(lotteryNumbersList);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    private void setWinningNumbers(String[] split) {
        if (split.length > 6 || split.length < 6) {
            throw new IllegalArgumentException("갯수를 맞춰주세요");
        }

        for (String number : split) {
            this.winningNumbers.addNumber(Integer.parseInt(number.trim()));
        }
    }

    private void compareLottoNumbers(List<LotteryNumbers> lotteryNumbersList) {
        for (LotteryNumbers lotteryNumbers : lotteryNumbersList) {
            setStatistics(lotteryNumbers.getLottoNumberList());
        }
    }

    private void setStatistics(List<Integer> lottoNumberList) {
        statistics.addCount(winningNumbers.countingWinningNumbers(lottoNumberList));
    }
}

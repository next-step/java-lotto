package lotto.domain;

public class WinningStatistics {
    private int[] matchesRecord;

    public WinningStatistics(LottoNumber winningLottoNumber, LottoNumbers lottoNumbers) {
        matchesRecord = lottoNumbers.calculateStatics(winningLottoNumber);

    }

    public int[] getMatchesRecord() {
        return matchesRecord;
    }
}

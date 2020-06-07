package com.cheolhyeonpark.lotto.domain;

import com.cheolhyeonpark.lotto.domain.number.LottoTicket;
import com.cheolhyeonpark.lotto.domain.number.Numbers;
import com.cheolhyeonpark.lotto.domain.number.WinningNumbers;

import java.util.List;
import java.util.stream.IntStream;

public class LottoManager {

    private final LottoTicket lottoTicket;

    public LottoManager(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoTicket createLottoNumbers(Count autoCount, List<String> manualNumbers) {
        addManualNumbers(manualNumbers);
        addAutoNumbers(autoCount);
        return lottoTicket;
    }

    private void addManualNumbers(List<String> manualNumbers) {
        manualNumbers.stream().map(Numbers::new).forEach(lottoTicket::addNumbers);
    }

    private void addAutoNumbers(Count count) {
        IntStream.range(0, count.getCount()).mapToObj(i -> new Numbers()).forEach(lottoTicket::addNumbers);
    }

    public LottoResult getGameResult(WinningNumbers winningNumbers) {
        return lottoTicket.getResult(winningNumbers);
    }
}

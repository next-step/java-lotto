package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumbers> lotteryNumbers;

    public LottoTicket() {
        lotteryNumbers = new ArrayList<>();
    }

    public LottoTicket(List<LottoNumbers> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LottoTicket with(LottoNumbers... lottoNumbersGroup) {
        return new LottoTicket(Arrays.asList(lottoNumbersGroup));
    }

    public void add(LottoNumbers lottoNumbers) {
        this.lotteryNumbers.add(lottoNumbers);
    }

    public List<LottoNumbers> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public int size() {
        return lotteryNumbers.size();
    }

    public LottoResults collectResults(LottoNumbers winningNumbers) {
        Map<LottoRank, List<LottoNumbers>> numbersGroupByPrize = lotteryNumbers.stream()
                .collect(Collectors.groupingBy(lottoNumbers -> LottoRank.of(lottoNumbers.match(winningNumbers))));
        return LottoResults.of(numbersGroupByPrize);
    }
}

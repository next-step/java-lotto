package lotto.domain;

import lotto.dto.IssueNumber;
import lotto.dto.LottoNumbers;

import java.util.LinkedHashMap;
import java.util.Map;

public class TotalLottoNumbers {

    private final Map<IssueNumber, LottoNumbers> totalLottoNumbers = new LinkedHashMap<>();

    public Map<IssueNumber, LottoNumbers> getTotalLottoNumbers() {
        return totalLottoNumbers;
    }

    public void recordEachLottoNumbers(IssueNumber issueNumber, LottoNumbers lottoNumbers) {
        totalLottoNumbers.put(issueNumber, new LottoNumbers(lottoNumbers.getLottoNumbers()));
    }
}

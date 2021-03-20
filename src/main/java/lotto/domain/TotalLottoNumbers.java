package lotto.domain;

import lotto.dto.IssueNumber;
import lotto.dto.LottoNumber;
import lotto.dto.LottoNumbers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TotalLottoNumbers {

    private final Map<IssueNumber, List<LottoNumber>> totalLottoNumbers = new LinkedHashMap<>();

    public Map<IssueNumber, List<LottoNumber>> getTotalLottoNumbers() {
        return totalLottoNumbers;
    }

    public void recordEachLottoNumbers(IssueNumber issueNumber, LottoNumbers lottoNumbers) {
        totalLottoNumbers.put(issueNumber, lottoNumbers.getLottoNumbers());
    }
}

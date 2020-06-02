package lotto.domain;

import lotto.domain.lotto.Price;
import lotto.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

public class LottoIssueRequest {
    private final Price price;
    private final List<List<Integer>> manualNumbers;


    public LottoIssueRequest(Price price, List<String> manualNumberString) {
        this.price = price;
        this.manualNumbers = createManualNumbers(manualNumberString);
    }

    public List<List<Integer>> createManualNumbers(List<String> manualNumberString) {
        return manualNumberString.stream()
                .map(StringUtil::splitAndToIntegerList)
                .collect(Collectors.toList());
    }
}

package step4.lotto.domain.numbers;

import step4.lotto.util.LottoErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class LottoManualNumber {

    private Set<LottoTicket> manualLottoSet = new HashSet<>();

    LottoManualNumber(List<String> manualNumber, int buyCount) {
        checkNumberSize(manualNumber, buyCount);
        checkManualNumber(manualNumber);
    }

    public Set<LottoTicket> getManualLottoSet() {
        return manualLottoSet;
    }

    private void checkNumberSize(List<String> manualNumber, int buyCount) {
        if (manualNumber.size() != buyCount) {
            throw new RuntimeException(LottoErrorMessage.getLottoCompareManualCountWithInputLottoNumber());
        }
    }

    private void checkManualNumber(List<String> manualNumber) {
        try {
            List<Integer> numberList = new ArrayList<>();

            for (String str : manualNumber) {
                String[] arr = str.replaceAll(" ", "").split(",");

                numberList = Arrays.asList(arr).stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                LottoTicket lottoTicket = new LottoTicket(numberList);

                manualLottoSet.add(lottoTicket);
            }
        } catch (Exception e) {
            throw new RuntimeException(LottoErrorMessage.getLottoNumberformatexception());
        }
    }
}

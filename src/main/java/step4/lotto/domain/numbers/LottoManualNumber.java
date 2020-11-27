package step4.lotto.domain.numbers;

import step4.lotto.util.LottoErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class LottoManualNumber {

    private Set<LottoTicket> manualLottoSet = new HashSet<>();

    LottoManualNumber(List<String> manualNumber, int buyCount) {
        initManualNumber(manualNumber, buyCount);
        checkManualNumber(manualNumber);
    }

    private void initManualNumber(List<String> manualNumber, int buyCount) {
        if (manualNumber.size() != buyCount) {
            throw new RuntimeException(LottoErrorMessage.getLottoComapreManualCountWithInputLottoNumber());
        }
    }

    public Set<LottoTicket> getManualLottoSet() {
        return manualLottoSet;
    }

    private void checkManualNumber(List<String> manualNumber) {
        try {
            List<Integer> numberList = new ArrayList<>();

            for (String str : manualNumber) {
                String[] arr = str.replaceAll(" ", "").split(",");

                isLottoNumber(arr);

                numberList = Arrays.asList(arr).stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                LottoNumber lottoNumber = new LottoNumber(numberList);
                LottoTicket lottoTicket = new LottoTicket(lottoNumber.getLottoNumber());

                manualLottoSet.add(lottoTicket);
            }
        } catch (Exception e) {
            throw new RuntimeException(LottoErrorMessage.getLottoNumberformatexception());
        }
    }

    private static void isLottoNumber(String[] lottoNumber) {
        try {
            for (String number : lottoNumber) {
                Integer.parseInt(number);
            }

        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessage.getLottoNumberformatexception());
        }
    }
}

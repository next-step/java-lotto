package lotto.view;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.WinInquiryRequest;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static LottoPurchaseRequest inputPurchaseInfo() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoPurchaseRequest(SCANNER.nextInt());
    }
    
    public static WinInquiryRequest inputWinNumbers(List<LottoNumbersDto> purchaseNumbers) {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        SCANNER.nextLine();
        return new WinInquiryRequest(purchaseNumbers, inputWinNumbers(SCANNER.nextLine()), inputBonusNumber());
    }

    private static LottoNumbersDto inputWinNumbers(String winNumbers) {
        List<Integer> winNumberList = Arrays.stream(winNumbers.split(NUMBER_DELIMITER))
                .map(winNumber -> Integer.valueOf(winNumber.trim()))
                .collect(Collectors.toList());
        return new LottoNumbersDto(winNumberList);
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}

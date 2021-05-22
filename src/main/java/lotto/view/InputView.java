package lotto.view;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.WinInquiryRequest;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LottoPurchaseRequest inputPurchaseInfo() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoPurchaseRequest(scanner.nextInt());
    }
    
    public WinInquiryRequest inputWinNumbers(List<LottoNumbersDto> purchaseNumbers) {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return new WinInquiryRequest(purchaseNumbers, inputWinNumbers(scanner.nextLine()));
    }

    private LottoNumbersDto inputWinNumbers(String winNumbers) {
        List<Integer> winNumberList = Arrays.stream(winNumbers.split(NUMBER_DELIMITER))
                .map(winNumber -> new Integer(winNumber.trim()))
                .collect(Collectors.toList());
        return new LottoNumbersDto(winNumberList);
    }
}

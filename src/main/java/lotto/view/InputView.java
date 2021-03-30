package lotto.view;

import lotto.controller.dto.LottoAutoPurchaseRequest;
import lotto.controller.dto.WinInquiryRequest;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LottoAutoPurchaseRequest inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoAutoPurchaseRequest(scanner.nextInt());
    }

    public WinInquiryRequest inputWinNumber(List<String> confirmTargetList) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return new WinInquiryRequest(scanner.nextLine(), removeBracket(confirmTargetList));
    }

    private List<String> removeBracket(List<String> confirmTargetList) {
        return confirmTargetList.stream()
                .map(confirmTarget -> confirmTarget.replace("[", ""))
                .map(confirmTarget -> confirmTarget.replace("]", ""))
                .collect(Collectors.toList());
    }

}

package lotto.view;

import lotto.controller.dto.LottoTicketPurchaseRequest;
import lotto.controller.dto.WinInquiryRequest;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LottoTicketPurchaseRequest inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoTicketPurchaseRequest(scanner.nextInt(), 0, null); // TODO : 수동구매갯수, 수동구입번호 입력로직 추가
    }

    public WinInquiryRequest inputWinInquiry(List<String> confirmTargetList) {
        return new WinInquiryRequest(inputWinNumber(), removeBracket(confirmTargetList), inputBonusNumber());
    }

    private String inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

    private List<String> removeBracket(List<String> confirmTargetList) {
        return confirmTargetList.stream()
                .map(confirmTarget -> confirmTarget.replace("[", ""))
                .map(confirmTarget -> confirmTarget.replace("]", ""))
                .collect(Collectors.toList());
    }

    private int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

}

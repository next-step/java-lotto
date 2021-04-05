package lotto.view;

import lotto.controller.dto.LottoTicketPurchaseRequest;
import lotto.controller.dto.WinInquiryRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LottoTicketPurchaseRequest inputPurchaseInfo() {
        return new LottoTicketPurchaseRequest(inputPurchaseAmount(), inputManualLottoPurchaseCount());
    }

    public LottoTicketPurchaseRequest inputPurchaseInfo(LottoTicketPurchaseRequest request) {
        return new LottoTicketPurchaseRequest(request.getPurchaseAmount(), inputManualLottoPurchaseNumberList(request.getManualLottoPurchaseCount()));
    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private int inputManualLottoPurchaseCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private List<String> inputManualLottoPurchaseNumberList(int manualLottoPurchaseCount) {
        List<String> manualLottoPurchaseNumberList = new ArrayList<>();
        if (manualLottoPurchaseCount > 0) {
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
            scanner.nextLine();
            for (int i = 0; i < manualLottoPurchaseCount; i++) {
                manualLottoPurchaseNumberList.add(scanner.nextLine());
            }
            return manualLottoPurchaseNumberList;
        }
        scanner.nextLine();
        return manualLottoPurchaseNumberList;
    }

    public WinInquiryRequest inputWinInquiry(List<String> confirmTargetList) {
        return new WinInquiryRequest(inputWinNumber(), removeBracket(confirmTargetList), inputBonusNumber());
    }

    private String inputWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
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

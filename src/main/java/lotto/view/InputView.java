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
        return new LottoPurchaseRequest(inputPurchaseAmount(), inputManualTicketCount());
    }

    public static LottoPurchaseRequest inputPurchaseInfo(LottoPurchaseRequest request) {
        return new LottoPurchaseRequest(request.getPurchaseAmount(),
                request.getManualLottoTicketCount(),
                inputManualLottoNumbers(request.getManualLottoTicketCount()));
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private static int inputManualTicketCount() {
        System.out.println(System.lineSeparator() + "수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private static List<LottoNumbersDto> inputManualLottoNumbers(int ticketCount) {
        SCANNER.nextLine();
        if (ticketCount == 0) {
            return Collections.emptyList();
        }
        System.out.println(System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumbersDto> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            manualLottoNumbers.add(inputLottoNumbers(SCANNER.nextLine()));
        }
        return manualLottoNumbers;
    }

    public static WinInquiryRequest inputLottoNumbers(List<LottoNumbersDto> purchaseNumbers) {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return new WinInquiryRequest(purchaseNumbers, inputLottoNumbers(SCANNER.nextLine()), inputBonusNumber());
    }

    private static LottoNumbersDto inputLottoNumbers(String inputNumbers) {
        List<Integer> winNumberList = Arrays.stream(inputNumbers.split(NUMBER_DELIMITER))
                .map(inputNumber -> Integer.valueOf(inputNumber.trim()))
                .collect(Collectors.toList());
        return new LottoNumbersDto(winNumberList);
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}

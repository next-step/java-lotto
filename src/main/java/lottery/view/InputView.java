package lottery.view;

import lottery.dto.LotteryNumbersDto;
import lottery.dto.LotteryTicketOrderDto;
import lottery.util.ConsoleInteractiveInputUtils;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String BASIC_DELIMITER = ",";

    public LotteryTicketOrderDto receiveLotteryTicketOrder() {
        int money = receivePurchaseAmount();
        int amount = receiveManualLotteryAmount();
        List<LotteryNumbersDto> lotteryNumbersDtoList = receiveManualLotteries(amount);

        return new LotteryTicketOrderDto(money, lotteryNumbersDtoList);
    }

    public int receivePurchaseAmount() {
        return ConsoleInteractiveInputUtils.getInt("구입 금액을 입력해주세요.");
    }

    public int receiveManualLotteryAmount() {
        return ConsoleInteractiveInputUtils.getInt("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    private List<LotteryNumbersDto> receiveManualLotteries(int amount) {
        String message = "수동으로 구매할 번호를 입력해 주세요.";

        return ConsoleInteractiveInputUtils.getIntegerLists(message, BASIC_DELIMITER, amount)
            .stream()
            .map(LotteryNumbersDto::new)
            .collect(Collectors.toList());
    }

    public List<Integer> receiveWinningNumbers() {
        return ConsoleInteractiveInputUtils.getListOfInteger("지난 주 당첨 번호를 입력해 주세요.", BASIC_DELIMITER);
    }

    public int receiveBonusNumber() {
        return ConsoleInteractiveInputUtils.getInt("보너스 볼을 입력해 주세요.");
    }

}

package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.exception.InputException;
import lotto.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.ui.output.GameOutput.NEW_LINE;

public class OmrCardInputData implements InputData<OmrCard> {
    private final GameInput input;

    public OmrCardInputData(Input input) {
        this.input = (GameInput) input;
    }

    @Override
    public OmrCard request() {
        try {
            int money = requestMoney();
            int count = calcCount(money);
            int manual = requestManualCount();

            List<String> numberCSVs = requestNumberCSVs(manual);

            OmrCard omrCard = new OmrCard();
            manualMarkings(numberCSVs, omrCard);
            autoMarkings(count, omrCard);

            input.response(String.format("%s수동으로 %d장, 자동으로 %d개를 구매했습니다.", NEW_LINE, manual, count - manual));
            input.response(omrCard.stream().map(omr -> omr.toString()).collect(Collectors.joining(NEW_LINE)));

            return omrCard;
        } catch (Exception e) {
            input.alertWarn(e.getMessage());
            return request();
        }
    }

    private int requestManualCount() throws InputException {
        String textCount = input.requestAfterNewLine("수동으로 구매할 로또 수를 입력해 주세요.");
        return parseInt(textCount, "수동으로 구매");
    }

    private List<String> requestNumberCSVs(int manual) throws InputException {
        return input.requestForMultipleValues(manual, "수동으로 구매할 번호를 입력해 주세요.");
    }

    private void manualMarkings(List<String> manualBallList, OmrCard omrCard) {
        for (String str : manualBallList) {
            int[] numbers = StringUtils.csvToIntArray(str);
            SixBall sixBall = SixBall.valueOf(numbers);

            omrCard.marking(sixBall);
        }
    }

    private void autoMarkings(final int totalCount, OmrCard omrCard) {
        while(omrCard.size() < totalCount) {
            SixBall sixBall = SixBall.valueOf();
            omrCard.marking(sixBall);
        }
    }

    private int requestMoney() throws InputException {
        String textMoney = input.request("구입금액을 입력해 주세요.");
        int money = parseInt(textMoney, "구입금액");

        if (OmrCard.isValidateMinimumAmount(money)) {
            throw new InputException(String.format("구입 최소금액은 %d원 입니다.", OmrCard.PRICE));
        }

        return money;
    }

    private int parseInt(String textMoney, String subject) throws InputException {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new InputException(String.format("%s은 숫자만 가능합니다.", subject));
        }
    }

    private int calcCount(int money) {
        int count = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > 0) {
            input.response((String.format("거스름돈 %d원을 돌려드립니다.", change)));
        }

        return count;
    }
}

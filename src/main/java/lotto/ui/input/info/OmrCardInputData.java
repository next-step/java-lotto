package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;
import lotto.ui.input.info.request.ManualNumberRequest;
import lotto.ui.input.info.request.TotalPurchaseCountRequest;
import lotto.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.ui.output.GameOutput.NEW_LINE;

public class OmrCardInputData implements InputData<OmrCard> {
    private final GameInput gameInput;
    private final TotalPurchaseCountRequest totalPurchaseCount;

    public OmrCardInputData(GameInput gameInput) {
        this.gameInput = gameInput;
        this.totalPurchaseCount = new TotalPurchaseCountRequest(gameInput);
    }

    @Override
    public OmrCard input() {
        try {
            int totalCount = totalPurchaseCount.request();
            List<String> numberCsvs = new ManualNumberRequest(gameInput, totalCount).request();
            OmrCard omrCard = intOmrCard(totalCount, numberCsvs);

            gameInput.response(String.format("%s수동으로 %d장, 자동으로 %d개를 구매했습니다.", NEW_LINE, numberCsvs.size(), totalCount - numberCsvs.size()));
            gameInput.response(omrCard.stream().map(omr -> omr.toString()).collect(Collectors.joining(NEW_LINE)));

            return omrCard;
        } catch (Exception e) {
            gameInput.alertWarn(e.getMessage());
            return input();
        }
    }

    private OmrCard intOmrCard(int count, List<String> numberCsvs) throws InputException {
        OmrCard omrCard = new OmrCard();
        manualMarkings(numberCsvs, omrCard);
        autoMarkings(count, omrCard);

        return omrCard;
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
}

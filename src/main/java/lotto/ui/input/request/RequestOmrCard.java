package lotto.ui.input.request;

import lotto.core.omr.OmrCard;
import lotto.dto.LottoPurchaseDTO;
import lotto.ui.input.Input;
import lotto.ui.output.Output;
import java.util.stream.Collectors;
import static lotto.ui.output.GameOutput.NEW_LINE;

public class RequestOmrCard {
    private final Output output;
    private final Input<String> input;

    public RequestOmrCard(final Output output, final Input<String> input) {
        this.output = output;
        this.input = input;
    }

    public OmrCard input() {
        OmrCard omrCard;
        try {
            omrCard = createOmrCard();
        } catch (Exception e) {
            output.error(e.getMessage());
            return input();
        }

        print(omrCard);

        return omrCard;
    }

    private OmrCard createOmrCard() {
        LottoPurchaseDTO lottoDTO = new LottoPurchaseDTO();

        lottoDTO.setMoney(input.request("구입금액을 입력해 주세요."));
        output.println("");

        lottoDTO.setManualCount(input.request("수동으로 구매할 로또 수를 입력해 주세요."));
        output.println("");

        output.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < lottoDTO.getManualCount(); i++) {
            lottoDTO.appendManualSixBalls(input.request(""));
        }
        output.println("");

        return lottoDTO.toOmrCard();
    }

    private void print(final OmrCard omrCard) {
        output.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", omrCard.getManualCount(), omrCard.getAutoCount()));
        output.println(
                omrCard.stream()
                        .map(omr -> omr.toString())
                        .collect(Collectors.joining(NEW_LINE))
        );
        output.println("");
    }

}

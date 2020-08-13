package lotto;

import common.StringResources;
import lotto.domain.LottoCreator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultNumber;
import lotto.ui.LottoInput;
import lotto.ui.LottoResultInput;
import lotto.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";

    private final int amountMoney;
    private List<LottoNumber> lottoNumberList;
    private LottoResultNumber lottoResultNumber;

    public LottoGame(LottoInput lottoInput) {
        amountMoney = lottoInput.getAmountMoney();
    }

    public void buy() {

        lottoNumberList = LottoCreator.create(amountMoney);

        for (LottoNumber lottoNumber : lottoNumberList) {

            String message = lottoNumber.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER, PREFIX, POSTFIX));

            ResultView.print(lottoNumber.toString());
        }
    }

    public void winning(LottoResultInput lottoResultInput) {
        ResultView.print(StringResources.MSG_WINNING_NUMBER);
    }
}

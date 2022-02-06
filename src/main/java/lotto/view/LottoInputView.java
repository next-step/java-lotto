package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;

public class LottoInputView {

    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final String LEFT_SQUARE_BRACKETS = "[";
    private static final String RIGHT_SQUARE_BRACKETS = "]";
    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final int ZERO = 0;

    private final StringBuilder stringBuilder = new StringBuilder();

    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusBall;
    private Lottos lottos;
    private int userPrice;

    public void prepareLottoGame(final LottoShop lottoShop) {
        System.out.println(INPUT_PRICE_MESSAGE);
        userPrice = LottoInput.inputPrice();
        int lottoAmount = lottoShop.countPossibleLottoAmount(userPrice);

        stringBuilder.append(lottoAmount)
            .append("개를 구매했습니다.");
        System.out.println(stringBuilder);

        lottos = lottoShop.buyLotto();

        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.getLottoNumbers());
        }

        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        winningNumbers = LottoInput.inputWinningNumber();

        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        bonusBall = new LottoNumber(LottoInput.inputBonusBall());
    }

    private void printLotto(final List<LottoNumber> lottoNumbers) {
        stringBuilder.setLength(ZERO);
        stringBuilder.append(LEFT_SQUARE_BRACKETS);

        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getNumber())
                .append(COMMA)
                .append(SPACE);
        }

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(SPACE));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));
        stringBuilder.append(RIGHT_SQUARE_BRACKETS);

        System.out.println(stringBuilder);
    }

    public List<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getPrice() {
        return this.userPrice;
    }
}

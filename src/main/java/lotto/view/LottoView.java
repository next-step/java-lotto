package lotto.view;

import java.util.List;

public class LottoView extends TextView {

    private static final String ASK_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String ASK_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_POSTFIX = "개를 구매했습니다.";
    private static final String ASK_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_POSTFIX = "]";
    private static final String TEXT_NEW_LINE = "\n";

    @Override
    public void view(Object o) {
        super.view(o);
    }

    public void printAskMoney() {
        view(ASK_MONEY_TEXT);
    }

    public void printAskWinNumber() {
        view(ASK_WIN_NUMBER);
    }

    public void printLottoCount(int lottoCount) {
        view(lottoCount + LOTTO_COUNT_POSTFIX);
    }

    public void printAskBonusNumber() {
        view(ASK_BONUS_NUMBER);
    }

    public void printLottoListNumber(List<List<Integer>> lottoListNumbers) {
        lottoListNumbers.forEach(this::printLottoNumber);
    }

    public void printLottoNumber(List<Integer> lottoNumbers) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LOTTO_NUMBER_PREFIX);
        lottoNumbers.stream().forEach(integer -> stringBuffer.append(integer).append(", "));
        stringBuffer.append(LOTTO_NUMBER_POSTFIX);
        stringBuffer.append(TEXT_NEW_LINE);

        System.out.print(stringBuffer.toString());
    }
}

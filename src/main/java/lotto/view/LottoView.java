package lotto.view;

import lotto.domain.LottoNo;

import java.util.List;

public class LottoView extends TextView {

    private static final String ASK_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String ASK_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ASK_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_POSTFIX = "개를 구매했습니다.";
    private static final String LOTTO_MANUAL_COUNT_PREFIX = "수동으로 ";
    private static final String LOTTO_MANUAL_COUNT_POSTFIX = "장, ";
    private static final String LOTTO_AUTO_COUNT_PREFIX = "자동으로 ";
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

    public void printAskManualCount() {
        view(ASK_MANUAL_COUNT);
    }

    public void printAskManualNumber() {
        view(ASK_MANUAL_NUMBER);
    }

    public void printAskWinNumber() {
        view(ASK_WIN_NUMBER);
    }

    public void printLottoCount(int manualLottoCount, int autoLottoCount) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LOTTO_MANUAL_COUNT_PREFIX)
                .append(manualLottoCount)
                .append(LOTTO_MANUAL_COUNT_POSTFIX)
                .append(LOTTO_AUTO_COUNT_PREFIX)
                .append(autoLottoCount)
                .append(LOTTO_COUNT_POSTFIX);

        view(stringBuffer.toString());
    }

    public void printAskBonusNumber() {
        view(ASK_BONUS_NUMBER);
    }

    public void printLottoListNumber(List<List<LottoNo>> lottoListNumbers) {
        lottoListNumbers.forEach(this::printLottoNumber);
    }

    public void printLottoNumber(List<LottoNo> lottoNumbers) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LOTTO_NUMBER_PREFIX);
        lottoNumbers.stream()
                .mapToInt(value -> value.getNumber())
                .sorted()
                .forEach(integer -> stringBuffer.append(integer).append(", "));
        stringBuffer.append(LOTTO_NUMBER_POSTFIX);
        stringBuffer.append(TEXT_NEW_LINE);

        System.out.print(stringBuffer.toString());
    }
}

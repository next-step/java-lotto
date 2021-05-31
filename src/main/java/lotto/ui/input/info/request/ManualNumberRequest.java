package lotto.ui.input.info.request;

import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;

import java.util.Collections;
import java.util.List;

public class ManualNumberRequest extends Request<List<String>> {
    private final int totalCount;

    public ManualNumberRequest(GameInput input, int totalCount) {
        super(input);

        this.totalCount = totalCount;
    }

    @Override
    public List<String> request() throws InputException {
        int manualCount = requestManualCount();
        if (totalCount < manualCount) {
            throw new InputException(String.format("수동으로 최대 %d개만 살수있습니다.", totalCount));
        }

        return requestNumberCsvs(manualCount);
    }

    private int requestManualCount() throws InputException {
        String textCount = input.requestAfterNewLine("수동으로 구매할 로또 수를 입력해 주세요.");
        return parseInt(textCount);
    }

    private List<String> requestNumberCsvs(int count) throws InputException {
        if (count == 0) {
            return Collections.EMPTY_LIST;
        }

        return input.requestForMultipleValues(count, "수동으로 구매할 번호를 입력해 주세요.");
    }

    private int parseInt(String textMoney) throws InputException {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new InputException("수동으로 구매건수는 숫자만 가능합니다.");
        }
    }

}

package lotto.view;

import lotto.domain.*;
import lotto.io.MessageReader;
import lotto.io.MessageWriter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoInputView {
    public static final String LOTTO_NUMBERS_INPUT_DELIMITER = ",";

    final MessageReader reader;
    final MessageWriter writer;

    public LottoInputView(final MessageReader reader, final MessageWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Money inputMoney() {
        writer.write("구입 금액을 입력해 주세요.");
        return new Money(reader.readInt());
    }

    public Lotto inputLastWeekWinningLotto() {
        writer.write("지난 주 당첨 번호를 입력해 주세요.");
        final String lottoNumbersInput = reader.readString();
        if (lottoNumbersInput.isEmpty()) {
            throw new IllegalArgumentException("지난 주 당첨 번호를 입력 해 주세요.");
        }

        if (!lottoNumbersInput.contains(LOTTO_NUMBERS_INPUT_DELIMITER)) {
            throw new IllegalArgumentException("지난 주 당첨 번호를 정확히 입력 해 주세요.");
        }

        final String[] lottoNumbers = lottoNumbersInput.split(LOTTO_NUMBERS_INPUT_DELIMITER);
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호를 정확히 입력 해 주세요.");
        }

        return new Lotto(
            Arrays.stream(lottoNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList())
        );
    }

    public void displayPurchaseLottoBundle(final LottoBundle lottoBundle) {
        writer.write(lottoBundle.size() + "개를 구매했습니다.");
        for (final Lotto lotto : lottoBundle) {
            writer.write(lotto.toString());
        }
    }
}

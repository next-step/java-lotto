package lotto.view;

import lotto.domain.*;
import lotto.io.MessageReader;
import lotto.io.MessageWriter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int inputManualLottoCount() {
        writer.write("수동으로 구매할 로또 수를 입력해 주세요.");
        return reader.readInt();
    }

    public List<String> inputManualLottoBundle(final int manualLottoCount) {
        writer.write("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> reader.readString())
                .collect(Collectors.toUnmodifiableList());
    }

    public LottoNumber inputBonusLottoNumber() {
        writer.write("보너스 볼을 입력해 주세요.");
        return new LottoNumber(reader.readInt());
    }

    public Lotto inputLastWeekWinningLotto() {
        writer.write("지난 주 당첨 번호를 입력해 주세요.");
        final String lottoNumbersInput = reader.readString();
        return createLotto(lottoNumbersInput);
    }

    private static Lotto createLotto(final String lottoNumbersInput) {
        return Lotto.createManualLotto(lottoNumbersInput, LOTTO_NUMBERS_INPUT_DELIMITER);
    }

    public void displayPurchaseLottoBundle(final LottoBundle lottoBundle) {
        writer.write("수동으로 " + lottoBundle.manualSize() + "개, 자동으로 " + lottoBundle.autoSize() + "개를 구매했습니다.");
        for (final Lotto lotto : lottoBundle) {
            writer.write(lotto.toString());
        }
    }
}

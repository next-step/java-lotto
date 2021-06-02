package lotto.store;

import java.util.ArrayList;
import java.util.List;

import interaction.InputView;
import interaction.OutputView;
import lotto.LottoNumbers;
import lotto.dto.ManualGameDto;
import lotto.generator.AutoLottoNumberGenerator;
import lotto.generator.MessageLottoNumberGenerator;

public class ManualLottoStore extends LottoStore {

    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MANUAL_AND_AUTOMATIC_COUNT_MESSAGE = "수동으로 %d장 자동으로 %d장 구매했습니다.";

    private final int manualCount;
    private final int automaticCount;

    public ManualLottoStore(ManualGameDto manualGameDto, int price) {
        super(manualGameDto.getBudget(), price);
        this.manualCount = manualGameDto.getManualCount();
        this.automaticCount = count - manualCount;
    }

    @Override
    public Ticket produceLotto() {
        List<LottoNumbers> result = new ArrayList<>(count);
        result.addAll(manualInputLotto());

        OutputView.sendMessage(String.format(MANUAL_AND_AUTOMATIC_COUNT_MESSAGE, manualCount, automaticCount));
        AutoLottoNumberGenerator autoGenerator = new AutoLottoNumberGenerator();
        result.addAll(autoGenerator.generate(automaticCount));
        return new Ticket(result, budget);
    }

    private List<LottoNumbers> manualInputLotto() {
        OutputView.sendMessage(MANUAL_LOTTO_COUNT_MESSAGE);
        List<LottoNumbers> result = new ArrayList<>(manualCount);
        MessageLottoNumberGenerator generator = new MessageLottoNumberGenerator();
        while (result.size() < manualCount) {
            result.add(generator.generate(InputView.lottoNumberMessage()));
        }
        return result;
    }

}

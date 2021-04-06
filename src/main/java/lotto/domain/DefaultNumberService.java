package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultNumberService implements LottoNumberService {
    private final List<Numbers> manualNumbers;

    public DefaultNumberService(List<Numbers> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    @Override
    public List<LottoGame> creation(Money money) {
        validate(money.lottoGameCount());
        List<LottoGame> manualGame = manualNumbers.stream()
                .map(numbers -> new LottoGame(numbers))
                .collect(Collectors.toList());

        if (isExistsAutoGame(money.lottoGameCount())) {
            Money autoGameMoney = money.remainMoney(manualNumbers.size());
            LottoNumberService autoNumberService = new AutoNumberService();
            manualGame.addAll(autoNumberService.creation(autoGameMoney));
        }

        return manualGame;
    }

    private void validate(int totalCount) {
        if (totalCount < manualNumbers.size()) {
            throw new IllegalArgumentException(String.format("구매할 수 있는 최대 수는 %d 입니다.", totalCount));
        }
    }

    private boolean isExistsAutoGame(int gameCount) {
        return manualNumbers.size() < gameCount;
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Games {

    private final List<LottoNumbers> games;

    public Games(int money) {
        int numberOfGames = money / LottoNumbers.PRICE;

        List<LottoNumbers> games = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            games.add(new LottoNumbers());
        }

        if (games.isEmpty()) {
            throw new IllegalArgumentException(String.format("최소 %d원이 필요합니다.", LottoNumbers.PRICE));
        }

        this.games = Collections.unmodifiableList(games);
    }

    public Games(List<LottoNumbers> games) {
        this.games = games;
    }

    public int count() {
        return games.size();
    }

    public List<Rank> checkResult(LottoNumbers winner, LottoNumber bonusLottoNumber) {
        return games.stream()
                .map(game -> Rank.of(
                        game.countIdenticalLottoNumberSet(winner),
                        game.hasBonusLottoNumber(bonusLottoNumber)
                ))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return games.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}

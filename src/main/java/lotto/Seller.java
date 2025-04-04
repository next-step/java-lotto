package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {
    private final LottoTicketMachine lottoTicketMachine;

    public static final int PRICE = 1000;

    public Seller() {
        this.lottoTicketMachine = new LottoTicketMachine(new Random());
    }

    public List<LottoGame> sell(int money) {
        int lottoCount = money / PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(it -> lottoTicketMachine.issueRandom())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LottoGame> sell(int money, List<List<Integer>> pickedNumbers) {
        int lottoCount = money / PRICE;

        var lottoGame = new ArrayList<LottoGame>();

        var manualGames = pickedNumbers.stream()
                .map(lottoTicketMachine::issueManual)
                .collect(Collectors.toUnmodifiableList());

        var randomGames = IntStream.range(0, lottoCount - manualGames.size())
                .mapToObj(it -> lottoTicketMachine.issueRandom())
                .collect(Collectors.toUnmodifiableList());

        lottoGame.addAll(manualGames);
        lottoGame.addAll(randomGames);

        return lottoGame;
    }
}

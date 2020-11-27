package lotto.domain;

import static lotto.domain.LottoGameConfig.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static List<Integer> lottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER+1).boxed().collect(Collectors.toList());

    private List<LottoTicket> lottoTickets;

    private int gameMoney;

    private List<String> manualTicket;

    public LottoTickets(int gameMoney, List<String> manualTicket) {
        this.gameMoney = (gameMoney/LOTTO_GAME_MONEY_UNIT) * LOTTO_GAME_MONEY_UNIT;

        int gameTryCount = (gameMoney/LOTTO_GAME_MONEY_UNIT) - manualTicket.size();

        this.lottoTickets = IntStream.range(0, gameTryCount)
                .mapToObj(ticket -> new LottoTicket(makeLottoNumber()))
                .collect(Collectors.toList());

        this.manualTicket = manualTicket;

        issueManualTicket();
    }

    private void issueManualTicket() {
        manualTicket.stream()
                .forEach(numbers -> lottoTickets.add(new LottoTicket(parseManualTicket(numbers))));
    }

    private List<Integer> parseManualTicket(String manualTicketValue){
        return Arrays.stream(manualTicketValue.split(",")).sorted()
                .map(i -> Integer.parseInt(i)).collect(Collectors.toList());
    }

    public int getGameMoney() {
        return this.gameMoney;
    }

    public List<String> getManualTicket(){
        return this.manualTicket;
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    private List<Integer> makeLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomLottoNumber  = lottoNumbers.stream().limit(LOTTO_TICKET_NUMBER_COUNT).collect(Collectors.toList());
        return randomLottoNumber;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<PrizeUnit> scoreWinningResult(List<Integer> lastWinningNumbers, int bonusNumber) {
        List<PrizeUnit> winResults = new ArrayList<>();
        lottoTickets.stream()
                .forEach(lottoTicket -> winResults.add(lottoTicket.countWinningNumbers(lastWinningNumbers, bonusNumber)));

        return winResults;
    }
}

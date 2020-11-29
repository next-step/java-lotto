package lotto.domain;

import static lotto.domain.LottoGameConfig.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    private final int gameMoney;

    private final List<LottoTicket> lottoTickets;

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER+1)
                .forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    public LottoTickets(int gameMoney) {
        this.gameMoney = (gameMoney/LOTTO_GAME_MONEY_UNIT) * LOTTO_GAME_MONEY_UNIT;
        this.lottoTickets = new ArrayList<>();
    }

    public int getGameMoney() {
        return this.gameMoney;
    }

    public void issueLottoTicket(List<List<LottoNumber>> manualTickets) {
        issueManualTicket(manualTickets);
        issueAutoTicket(manualTickets.size());
    }

    private void issueManualTicket(List<List<LottoNumber>> manualTickets) {
        manualTickets.stream()
                .forEach(lottoNumbers -> {
                    lottoTickets.add(new LottoTicket(lottoNumbers, false));
                });
    }

    private void issueAutoTicket(int manualTicketSize){
        int gameTryCount = (gameMoney/LOTTO_GAME_MONEY_UNIT) - manualTicketSize;
        IntStream.range(0, gameTryCount)
                .forEach(ticket-> lottoTickets.add(new LottoTicket(makeLottoNumber(), true)));
    }

    private List<LottoNumber> makeLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumber  = lottoNumbers.stream().limit(LOTTO_TICKET_NUMBER_COUNT).collect(Collectors.toList());
        return randomLottoNumber;
    }

    public int countLottoTickets() {
        return lottoTickets.size();
    }

    public int countManualTickets() {
        return (int) lottoTickets.stream().filter(lottoTicket -> !lottoTicket.isAutoGenerate()).count();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<PrizeUnit> scoreWinningResult(List<LottoNumber> lastWinningNumbers, LottoNumber bonusNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.countWinningNumbers(lastWinningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

}

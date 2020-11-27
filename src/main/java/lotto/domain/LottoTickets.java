package lotto.domain;

import static lotto.domain.LottoGameConfig.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    private List<LottoTicket> lottoTickets;

    private int gameMoney;

    private List<List<LottoNumber>> manualTickets;

    public LottoTickets(int gameMoney, List<List<LottoNumber>> manualTickets) {

        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER+1).forEach(number -> lottoNumbers.add(new LottoNumber(number)));

        this.gameMoney = (gameMoney/LOTTO_GAME_MONEY_UNIT) * LOTTO_GAME_MONEY_UNIT;

        int gameTryCount = (gameMoney/LOTTO_GAME_MONEY_UNIT) - manualTickets.size();

        this.lottoTickets = IntStream.range(0, gameTryCount)
                .mapToObj(ticket -> new LottoTicket(makeLottoNumber()))
                .collect(Collectors.toList());

        this.manualTickets = manualTickets;

        issueManualTicket();
    }

    private void issueManualTicket() {
        manualTickets.stream()
                .forEach(lottoNumbers -> lottoTickets.add(new LottoTicket(validateManualTicket(lottoNumbers))));
    }

    private List<LottoNumber> validateManualTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_MANUAL_TICKET_NUMBER.getErrorMessage());
        }

        if(lottoNumbers.stream().anyMatch(number -> number.getNumber() > MAX_LOTTO_NUMBER)){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_MANUAL_TICKET_NUMBER.getErrorMessage());
        }

        return lottoNumbers;
    }

    public int getGameMoney() {
        return this.gameMoney;
    }

    public List<List<LottoNumber>> getManualTicket(){
        return this.manualTickets;
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    private List<LottoNumber> makeLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumber  = lottoNumbers.stream().limit(LOTTO_TICKET_NUMBER_COUNT).collect(Collectors.toList());
        return randomLottoNumber;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<PrizeUnit> scoreWinningResult(List<LottoNumber> lastWinningNumbers, int bonusNumber) {
        List<PrizeUnit> winResults = new ArrayList<>();
        lottoTickets.stream()
                .forEach(lottoTicket -> winResults.add(lottoTicket.countWinningNumbers(lastWinningNumbers, bonusNumber)));

        return winResults;
    }
}

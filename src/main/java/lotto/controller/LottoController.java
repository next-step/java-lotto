package lotto.controller;

public class LottoController {

//    public LottoTickets buyAndPrintLotto() {
//        String purchaseAmount = InputView.purchaseAmount();
//        LottoTickets lottoTickets = LottoTicketFactory.buy(purchaseAmount);
//        OutputView.printNumberOfPurchase(lottoTickets.size());
//        printLottoNumbersList(lottoTickets);
//        return lottoTickets;
//    }
//
//    private void printLottoNumbersList(LottoTickets lottoTickets) {
//        List<LottoTicket> lottoTicketList = lottoTickets.getLottos();
//        for (LottoTicket lottoTicket : lottoTicketList) {
//            OutputView.printLottoNumbers(lottoTicket.getLottoNumbers());
//        }
//    }
//
//    public void winningInformationOf(LottoTickets lottoTickets) {
//        String winningLotteryNumbers = InputView.winningLotteryNumbers();
//        String bonusNumber = InputView.bonusNumber();
//        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningLotteryNumbers, bonusNumber);
//        Map<Integer, Integer> countNumberOfMatching = lottoTickets.countNumberOfMatching(lottoWinningNumbers);
//        LottoWinningRules lottoWinningRules = lottoTickets.getLottoWinningRules();
//        List<WinningInformationDto> winningInformationDtoList = winningInformationList(countNumberOfMatching, lottoWinningRules);
//        OutputView.printWinningStatics(winningInformationDtoList);
//        double earningRate = lottoTickets.earningRate(countNumberOfMatching);
//        OutputView.earningRate(earningRate);
//    }
//
//    private List<WinningInformationDto> winningInformationList(Map<Integer, Integer> countNumberOfMatching, LottoWinningRules lottoWinningRules) {
//        Set<Integer> numberOfMatchingSet = lottoWinningRules.numberOfMatchingSet();
//        List<WinningInformationDto> winningInformationDto = new ArrayList<>();
//        for (int numberOfMatching : numberOfMatchingSet) {
//            int prizeMoney = lottoWinningRules.getPrizeOf(numberOfMatching);
//            int numberOfWinning = countNumberOfMatching.getOrDefault(numberOfMatching, 0);
//            winningInformationDto.add(new WinningInformationDto(numberOfMatching, prizeMoney, numberOfWinning));
//        }
//        return winningInformationDto;
//    }

}

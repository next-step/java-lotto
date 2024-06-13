package view;

import domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoView {

    private final LottoGame lottoGame;
    private final Scanner scanner;

    public LottoView() {
        this.lottoGame = LottoGame.policyFrom(new GeneralLottoGamePolicy());
        this.scanner = new Scanner(System.in);
    }

    public void manual() {
        ArrayList<Lotto> lottos = new ArrayList<>();
        int totalTicketCount = getTicketCountWithScanner();
        int manualTicketCount = getManualTicketCountWithScanner(totalTicketCount);
        int autoTicketCount = totalTicketCount - manualTicketCount;
        lottos.addAll(getLottosWithScanner(manualTicketCount));
        lottos.addAll(lottoGame.generateLotto(autoTicketCount));
        printTicketCount(manualTicketCount, autoTicketCount);
        printLottos(lottos);
        WinningLotto winningLotto = getWinningLottoWithScanner();
        printLottoResult(getLottoResult(lottos, winningLotto), totalTicketCount);
    }

    private void printTicketCount(int manualTicketCount, int autoTicketCount) {
        System.out.println(System.lineSeparator()
                + "수동으로 " + manualTicketCount + "장, 자동으로 " + autoTicketCount + "개를 구매했습니다.");
    }

    public void auto() {
        int ticketCount = getTicketCountWithScanner();
        ArrayList<Lotto> lottos = lottoGame.generateLotto(ticketCount);
        printLottos(lottos);
        WinningLotto winningLotto = getWinningLottoWithScanner();
        printLottoResult(getLottoResult(lottos, winningLotto), ticketCount);
    }

    private HashMap<LottoGamePrize, Integer> getLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        HashMap<LottoGamePrize, Integer> result = new HashMap<>();
        Arrays.stream(LottoGamePrize.values()).forEach(prize -> result.put(prize, 0));

        for (Lotto lotto : lottos) {
            LottoGamePrize prize = lottoGame.match(lotto, winningLotto);
            result.put(prize, result.get(prize) + 1);
        }
        return result;
    }

    private int getTicketCountWithScanner() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return Integer.parseInt(scanner.nextLine()) / Lotto.PRICE;
            } catch (NumberFormatException e) {
                System.out.println("올바른 금액을 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private ArrayList<Lotto> getLottosWithScanner(int manualTicketCount) {
        while (true) {
            try {
                System.out.println(System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.");
                ArrayList<Lotto> lottos = new ArrayList<>();
                for (int i = 0; i < manualTicketCount; i++) {
                    lottos.add(Lotto.of(Arrays.stream(scanner.nextLine()
                            .replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray()));
                }
                return lottos;
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getManualTicketCountWithScanner(int totalTicketCount) {
        while (true) {
            try {
                System.out.println(System.lineSeparator() + "수동으로 구매할 로또 수를 입력해 주세요.");
                int manualTicketCount = Integer.valueOf(scanner.nextLine().trim()).intValue();
                if(manualTicketCount >= totalTicketCount)
                    throw new IllegalArgumentException("구입 가능한 로또 개수를 초과했습니다");
                return manualTicketCount;
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자을 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottoResult(HashMap<LottoGamePrize, Integer> result, int ticketCount) {

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(GeneralLottoGamePolicy.FIFTH_PRIZE_MATCH_COUNT + "개 일치 (" + LottoGamePrize.FIFTH_PRIZE.getValue() + "원)- " + result.get(LottoGamePrize.FIFTH_PRIZE) + "개");
        System.out.println(GeneralLottoGamePolicy.FOURTH_PRIZE_MATCH_COUNT + "개 일치 (" + LottoGamePrize.FOURTH_PRIZE.getValue() + "원)- " + result.get(LottoGamePrize.FOURTH_PRIZE) + "개");
        System.out.println(GeneralLottoGamePolicy.THIRD_PRIZE_MATCH_COUNT + "개 일치 (" + LottoGamePrize.THIRD_PRIZE.getValue() + "원)- " + result.get(LottoGamePrize.THIRD_PRIZE) + "개");
        System.out.println(GeneralLottoGamePolicy.SECOND_PRIZE_MATCH_COUNT + "개 일치 (" + LottoGamePrize.SECOND_PRIZE.getValue() + "원)- " + result.get(LottoGamePrize.SECOND_PRIZE) + "개");
        System.out.println(GeneralLottoGamePolicy.FIRST_PRIZE_MATCH_COUNT + "개 일치 (" + LottoGamePrize.FIRST_PRIZE.getValue() + "원)- " + result.get(LottoGamePrize.FIRST_PRIZE) + "개");
        System.out.println("총 수익률은 " + Math.floor(lottoGame.calculateRoi(result, ticketCount) * 100.0)/100.0 + "입니다.");
    }
    private WinningLotto getWinningLottoWithScanner() {
        while (true) {
            try {
                System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
                Lotto lotto = Lotto.of(Arrays.stream(scanner.nextLine()
                        .replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray());
                System.out.println("보너스 볼을 입력해 주세요.");
                return WinningLotto.of(lotto, LottoNumber.from(Integer.parseInt(scanner.nextLine().trim())));
            } catch (NumberFormatException e) {
                System.out.println("올바른 금액을 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.getNumbers().stream()
                    .sorted()
                    .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                    .collect(Collectors.joining(", ")) + "]");
        }
    }
}

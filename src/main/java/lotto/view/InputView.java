package lotto.view;

import collection.PositiveNumber;
import lotto.model.Amount;
import lotto.model.LottoNum;
import lotto.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static int MAX_SIZE = 6;

    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 로또 구매
     *
     * @return
     */
    public static Amount purcharseLotto() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        return new Amount(new PositiveNumber(sc.next()).getValue());
    }

    /**
     * 수동으로 구매할 로또 수
     *
     * @return
     */
    public static int purcharseManual(Amount buyAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int num = new PositiveNumber(sc.next()).getValue().intValue();
        buyAmount.purcharseTicket(num);

        return num;
    }

    /**
     * 수동으로 구매한 로또 가져오기
     *
     * @param manualNum
     * @return
     */
    public static List<Ticket> getManualTicket(int manualNum) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        ArrayList<Ticket> tickets = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < manualNum; i++) {
            tickets.add(createManualTicket(split(sc.next())));
        }

        return tickets;
    }

    /**
     * 티켓 생성
     * @param strPrizeNums
     * @return
     */
    private static Ticket createManualTicket(String[] strPrizeNums) {
        if (isOverMaxSize(strPrizeNums)) {
            throw new IllegalStateException("최대 6개의 숫자만 입력 가능");
        }

        return new Ticket(LottoNum.toLottoNums(toPositiveNums(strPrizeNums)));
    }

    /**
     * 티켓 만들 수 있는지 여부
     * @param strPrizeNums
     * @return
     */
    private static boolean isOverMaxSize(String[] strPrizeNums) {
        return strPrizeNums.length > MAX_SIZE;
    }


    /**
     * 당첨번호 가져오기
     *
     * @return
     */
    public static List<LottoNum> getPrizeNums() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strPrizeNums = split(s);

        return LottoNum.toLottoNums(toPositiveNums(strPrizeNums));
    }

    public static LottoNum getBounsNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);

        return LottoNum.toLottoNum(new PositiveNumber(sc.next()).getValue().intValue());
    }

    /**
     * 양의 정수로 변환
     *
     * @param strPrizeNums
     * @return
     */
    private static List<Integer> toPositiveNums(String[] strPrizeNums) {
        ArrayList<Integer> prizeNums = new ArrayList<>();
        for (int i = 0; i < strPrizeNums.length; i++) {
            prizeNums.add(new PositiveNumber(strPrizeNums[i]).getValue().intValue());
        }

        return prizeNums;
    }


    /**
     * 분리
     *
     * @param s
     * @return
     */
    private static String[] split(String s) {
        return s.split(",");
    }
}

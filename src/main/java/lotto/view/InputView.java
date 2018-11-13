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
     * @return
     */
    public static Amount purcharseLotto() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        return new Amount(new PositiveNumber(sc.next()).getValue());
    }

    /**
     * 수동으로 구매할 로또 수
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
     * @param manualNum
     * @return
     */
    public static List<Ticket> getManualTicket(int manualNum) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        ArrayList<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < manualNum; i++) {
            Scanner sc = new Scanner(System.in);
            String[] strPrizeNums = split(sc.next());

            if(strPrizeNums.length > MAX_SIZE) {
                throw new IllegalStateException("최대 6개의 숫자만 입력 가능");
            }

            tickets.add(new Ticket(toLottoNums(toPositiveNums(strPrizeNums)),false));
        }

        return tickets;
    }


    /**
     * 당첨번호 가져오기
     * @return
     */
    public static List<LottoNum> getPrizeNums() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strPrizeNums = split(s);

        return toLottoNums(toPositiveNums(strPrizeNums));
    }

    public static LottoNum getBounsNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);

        return new LottoNum(new PositiveNumber(sc.next()).getValue().intValue());
    }

    /**
     * 양의 정수로 변환
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
     * 양의 정수로 변환
     * @param strPrizeNums
     * @return
     */
    public static List<LottoNum> toLottoNums(List<Integer> prizeNums) {
        ArrayList<LottoNum> lottoNums = new ArrayList<>();
        for (int i = 0; i < prizeNums.size(); i++) {
            lottoNums.add(new LottoNum(prizeNums.get(i)));
        }

        return lottoNums;
    }

    /**
     * 분리
     * @param s
     * @return
     */
    private static String[] split(String s) {
        return s.split(",");
    }
}

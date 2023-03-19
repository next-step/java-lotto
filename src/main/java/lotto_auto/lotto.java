package lotto_auto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class lotto {

    public static void main(String[] args) {

        ArrayList<Integer>[] lottoNumbers = new ArrayList[1000];
        int winningTicketCnt[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

        int lottoCnt = getBuyTicketCount();
        lottoNumbers = getLottoTicket(lottoCnt);
        String winNums = getWinNumber();
        String bonusNums = getBonusNumber();
        List<Integer> winningNumbers = setWinngNumber(winNums);

        for (int i = 0; i < lottoCnt; i++) {
            int matchCount = Math.toIntExact(winningNumbers.stream().filter(lottoNumbers[i]::contains).count());
            boolean bonus = lottoNumbers[i].toString().contains(bonusNums);
            winningTicketCnt = gradeCount(matchCount, bonus, winningTicketCnt);
        }
        resultLotto(winningTicketCnt);
    }

    public static int[] gradeCount(int matchCount, boolean bonusMatch, int[] winningTicketCnt) {

        if (matchCount < 3) {
            matchCount = 0;
        }
        if (bonusMatch && matchCount == 5) {
            matchCount = 7;
        }
        winningTicketCnt[matchCount]++;

        return winningTicketCnt;
    }

    public static int getBuyTicketCount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner in = new Scanner(System.in);
        String Amount = in.nextLine();

        String buyAmout = getBuyAmt(Amount);

        int buyAmt = Integer.parseInt(buyAmout);
        int lottoCnt = buyAmt / 1000;
        System.out.println(lottoCnt + "개를 구매했습니다.");

        return lottoCnt;
    }

    public static String getBuyAmt(String Amt) {

        if (Integer.parseInt(Amt) < 1000 ) {
            throw new IllegalArgumentException("1000원 이하는 구매불가능합니다.");
        }
        return Amt;
    }

    public static ArrayList<Integer> getLottoNumber() {

        ArrayList<Integer> lottoList = new ArrayList<Integer>();
        ArrayList<Integer> lottoNumber = new ArrayList<Integer>();

        for (int i = 1; i < 46; i++) {
            lottoList.add(i);
        }
        Collections.shuffle(lottoList);
        for (int i = 0; i < 6; i++) {
            lottoNumber.add(i, lottoList.get(i));
        }
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    private static List<Integer> setWinngNumber(String winNums) {
        return Arrays.stream(winNums.split(","))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }

    private static ArrayList<Integer>[] getLottoTicket(int lottoCnt) {

        ArrayList<Integer>[] lottoNumbers = new ArrayList[1000];

        for (int i = 0; i < lottoCnt; i++) {
            lottoNumbers[i] = getLottoNumber();
        }
        viewTicketNumber(lottoNumbers, lottoCnt);
        return lottoNumbers;
    }
    private static void viewTicketNumber(ArrayList<Integer>[] lottoNumbers, int lottoCnt) {
        for (int i = 0; i < lottoCnt; i++) {
            System.out.println(Arrays.deepToString(lottoNumbers[i].toArray()));
        }
        return;
    }
    private static String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner in_bonusNum = new Scanner(System.in);
        String bonusNums = in_bonusNum.nextLine();
        return bonusNums;
    }
    private static String getWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner in_winNum = new Scanner(System.in);

        String winNums = in_winNum.nextLine();

        return winNums.replace(" ", "");
    }
    private static void resultLotto(int[] winningTicketCnt) {
        BigDecimal profitRate = new BigDecimal(0.0);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(grade.fifthRank.getMatchCount() + "개 일치 (" + grade.fifthRank.getWinningMoney() + "원) - " + winningTicketCnt[3] + "개");
        System.out.println(grade.fourthRank.getMatchCount() + "개 일치 (" + grade.fifthRank.getWinningMoney() + "원) - " + winningTicketCnt[4] + "개");
        System.out.println(grade.thirdRank.getMatchCount() + "개 일치 (" + grade.thirdRank.getWinningMoney() + "원) - " + winningTicketCnt[5] + "개");
        System.out.println(grade.secondRank.getMatchCount() + "개 일치, 보너스 볼 일치(" + grade.secondRank.getWinningMoney() + "원) - " + winningTicketCnt[7] + "개");
        System.out.println(grade.oneRank.getMatchCount() + "개 일치 (" + grade.oneRank.getWinningMoney() + "원) - " + winningTicketCnt[6] + "개");

    }

}
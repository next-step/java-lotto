package step2.view;

public class ResultView {
    public static int countOfTickets(int purchase) {

        int cnt = purchase/1000;

        System.out.println(String.format("%d개를 구매했습니다.", cnt));

        return cnt;
    }
}

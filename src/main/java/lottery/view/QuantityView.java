package lottery.view;

public class QuantityView {

    private static final String QUANTITY_FORM = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public static void printQuantity(int manual, int auto) {
        System.out.printf((QUANTITY_FORM) + "%n",manual,auto);
    }
}

package AutoLotto.view;

public class InputView {

    private static SystemInput systemIn = new SystemInput();

    private InputView(){}

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return systemIn.getIntValue();
    }

    // 13?5?6 ... : 우선 정수인지만 regex 받고 : 그다음 lottoNumber 유효조건 확인
    public static String getBuzzLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = systemIn.getStringValue( );
        String[] tokens = input.split("");
        return systemIn.getStringValue();
    }

}

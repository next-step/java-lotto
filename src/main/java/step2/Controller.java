package step2;

import static step2.PlayRounds.getPlayRounds;

public class Controller {

    public static void main(String[] args){
        InputView inputView = new InputView();
        int price = 0;
        int rounds = 0;

        try {
            price = stringToInteger(inputView.inputPrice());
            rounds = getPlayRounds(price);

            for (int i = 0; i < rounds; i++) {
                Lotto lotto = new Lotto();
                lotto.printLotto();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static int stringToInteger(String text){
        text = text.trim();
        if (text.isEmpty() && text.isBlank()){
            System.out.println("입력된 값이 없습니다.");
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(text);
    }

}

package step2;

public class Controller {

    public static void main(String[] args){
        InputView inputView = new InputView();
        int price = 0;
        int rounds = 0;

        try {
            price = stringToInteger(inputView.inputPrice());
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

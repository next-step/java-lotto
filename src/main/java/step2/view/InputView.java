package step2.view;

import step2.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public String ask(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public List<Lotto> askManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualLotto = getInput();
            manualLottoList.add(new Lotto(manualLotto));
        }

        return manualLottoList;
    }
}

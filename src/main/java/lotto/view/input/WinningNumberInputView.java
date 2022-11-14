package lotto.view.input;

import lotto.model.WinningNumber;

public class WinningNumberInputView {
    private final UserInterface userInterface;

    public WinningNumberInputView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public WinningNumber getWinningNumber() {
        userInterface.show("지난 주 당첨 번호를 입력해 주세요.");
        return WinningNumber.from(userInterface.getString());
    }
}

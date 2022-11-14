package lotto.view.input;

import lotto.model.BonusNumber;

public class BonusNumberInputView {
    private final UserInterface userInterface;

    public BonusNumberInputView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public BonusNumber getBonusNumber() {
        userInterface.show("보너스 볼을 입력해 주세요.");

        return BonusNumber.of(userInterface.getInt());
    }
}

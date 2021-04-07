package step4.domain.winning;

public final class WinningCheckMachine {

    private static class WinningCheckMachineHolder {
        private static WinningCheckMachine instance = new WinningCheckMachine();
    }

    private WinningCheckMachine() {
    }

    public static final WinningCheckMachine getInstance() {
        return WinningCheckMachineHolder.instance;
    }
}

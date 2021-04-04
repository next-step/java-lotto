package step3.domain.winning;

public final class WinningCheckMachine {

    private static class WinningCheckMachineHolder {
        public static final WinningCheckMachine instance = new WinningCheckMachine();
    }

    private WinningCheckMachine() {
    }

    public static final WinningCheckMachine getInstance() {
        return WinningCheckMachineHolder.instance;
    }

}

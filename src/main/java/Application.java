import lotto.view.AutoRottoRunner;
import lotto.view.ManualRottoRunner;

public class Application {
    public static void main(String[] args) {
        if (args.length > 0 && "auto".equals(args[0])) {
            new AutoRottoRunner().run();
            return;
        }

        new ManualRottoRunner().run();
    }
}

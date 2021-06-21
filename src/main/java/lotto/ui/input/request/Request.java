package lotto.ui.input.request;

import lotto.core.round.Round;
import lotto.ui.input.Input;
import lotto.ui.output.GameOutput;
import lotto.ui.output.Output;
import java.util.function.Supplier;

public abstract class Request<R> {
    protected final Output output;
    protected final Input<String> input;

    public Request(final Output output, final Input<String> input) {
        this.output = output;
        this.input = input;
    }

    public abstract R input();

    protected Round request(Supplier<Round> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            alertError(e);
            return request(supplier);
        }
    }

    protected void request(VoidConsumer consumer) {
        try {
            consumer.accept();
        } catch (Exception e) {
            alertError(e);
            request(consumer);
        }
    }

    private void alertError(final Exception e) {
        output.error(e.getMessage());
        output.println(String.format("다시 입력해 주시기 바랍니다.", GameOutput.NEW_LINE));
    }

    @FunctionalInterface
    protected interface VoidConsumer {
        void accept();
    }

}

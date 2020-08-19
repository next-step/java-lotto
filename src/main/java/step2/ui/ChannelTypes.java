package step2.ui;

import step2.ui.input.InputChannel;
import step2.ui.input.SystemIn;
import step2.ui.output.OutputChannel;
import step2.ui.output.SystemOut;

import java.util.function.Supplier;

public enum ChannelTypes {
	SYSTEM(SystemIn::new, SystemOut::new);

	private final Supplier<InputChannel> inputChannelSupplier;
	private final Supplier<OutputChannel> outputChannelSupplier;

	ChannelTypes(Supplier<InputChannel> inputChannelSupplier, Supplier<OutputChannel> outputChannelSupplier) {
		this.inputChannelSupplier = inputChannelSupplier;
		this.outputChannelSupplier = outputChannelSupplier;
	}

	public InputChannel getInputChannel() {
		return inputChannelSupplier.get();
	}

	public OutputChannel getOutputChannel() {
		return outputChannelSupplier.get();
	}
}

package step3.ui.output;

import step3.ui.ChannelTypes;

import static step3.ui.ChannelTypes.SYSTEM;

public interface OutputChannel {

	static OutputChannel getChannel(ChannelTypes channelTypes) {
		return channelTypes.getOutputChannel();
	}

	static OutputChannel getSystemOutChannel() {
		return getChannel(SYSTEM);
	}

	void printLine(String input);
}

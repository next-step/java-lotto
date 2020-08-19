package step3.ui.input;

import step3.ui.ChannelTypes;

import static step3.ui.ChannelTypes.SYSTEM;

public interface InputChannel {

	static InputChannel getChannel(ChannelTypes channelTypes) {
		return channelTypes.getInputChannel();
	}

	static InputChannel getSystemInChannel() {
		return getChannel(SYSTEM);
	}

	int getIntValue();

	String getStringValue();
}

package mediator;

import java.awt.Button;
/**
 * LoginFrameクラス(Mediatorインターフェース)と協調動作を行う
 *
 */
public class ColleagueButton extends Button implements Colleague{
	private Mediator mediator;

	public ColleagueButton(String caption) {
		super(caption);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	// Mediatorから有効/無効が指示される
	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}
}

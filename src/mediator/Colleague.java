package mediator;

public interface Colleague {
	public abstract void setMediator(Mediator mediator);
	// 相談役からやってくる指示に該当
	public abstract void setColleagueEnabled(boolean enabled);
}

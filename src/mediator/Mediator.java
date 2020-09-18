package mediator;

public interface Mediator {
	// このMediatorが管理するメンバーを生成する
	public abstract void createColleagues();
	// 相談役への相談
	public abstract void collegueChanged();
}

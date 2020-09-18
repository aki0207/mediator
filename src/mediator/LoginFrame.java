package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckBox checkGuest;
	private ColleagueCheckBox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	 public LoginFrame(String title) {
		 super(title);
		 setBackground(Color.lightGray);
		 // レイアウトマネージャーを使って4×2のグリッドを作る
		 setLayout(new GridLayout(4, 2));
		 // Colleagueたちの生成
		 createColleagues();
		 // 配置
		 add(checkGuest);
		 add(checkLogin);
		 add(new Label("User name:"));
		 add(textUser);
		 add(new Label("Password:"));
		 add(textPass);
		 add(buttonOk);
		 add(buttonCancel);
		 // 有効/無効の初期設定
		 collegueChanged();
		 // 表示
		 pack();
		 show();
	}

	@Override
	public void createColleagues() {
		// 生成
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckBox("Guest", g, true);
		checkLogin = new ColleagueCheckBox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		// Mediator(相談役)のセット
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// Listenerのセット
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// Colleagueからの通知で有効/無効を判定する
	@Override
	public void collegueChanged() {
		if (checkGuest.getState()) {
			// Guestモード
			textPass.setColleagueEnabled(true);
			if (textPass.getText().length() > 0) {
				buttonOk.setEnabled(true);
			} else {
				buttonOk.setEnabled(false);
			}
		} else {
			// Loginモード
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	// textUserまたはtextPassの変更があった
	// 各Colleagueの有効/無効を判定する
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.exit(0);
	}

}

package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "名前の入力は必須です")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "メールアドレスの入力は必須です")
	@Email(message = "メールアドレスの形式が不正です")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "パスワードの入力は必須です")
	@Size(min = 8, message = "パスワードは8文字以上で入力してください")
	private String password;
	/**　確認用パスワード */
	@NotBlank(message = "確認用パスワードの入力は必須です")
	@Size(min = 8, message = "確認用パスワードは8文字以上で入力してください")
	private String checkPassword;

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ ", checkPassword=" + checkPassword + "]";
	}

}

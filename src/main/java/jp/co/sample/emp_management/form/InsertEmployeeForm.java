package jp.co.sample.emp_management.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * 従業員登録用のフォーム
 * 
 * @author takara.miyazaki
 *
 */
public class InsertEmployeeForm {
	
	/** ID */
	private String id;
	/** 名前 */
	@NotBlank(message = "名前を入力してください")
	private String name;
	/** 画像 */
	private MultipartFile imageFile;
	/** 画像のパス */
	private String image;
	/** 性別 */
	@NotBlank(message = "性別を入力してください")
	private String gender;
	/** 入社日 */
	@NotBlank(message = "入社日を入力してください")
	private String hireDate;
	/** メールアドレス */
	@Size(min=1, max=127, message="Eメールは1文字以上127文字以内で記載してください")
	@Email(message = "Eメールの形式が不正です")
	private String mailAddress;
	/** 郵便番号 */
	@NotBlank(message = "郵便番号を入力してください")
	@Pattern(regexp="^\\d{3}[-]\\d{4}$", message="半角数字でハイフンをつけて入力してください")
	private String zipCode;
	/** 住所 */
	@NotBlank(message = "住所を入力してください")
	private String address;
	/** 電話番号 */
	@NotBlank(message = "電話番号を入力してください")
	@Pattern(regexp="^[0-9]{2,4}-[0-9]{2,4}-[0-9]{3,4}$", message="半角数字でハイフンをつけて入力してください")
	private String telephone;
	/** 給与 */
	@NotBlank(message = "給与を入力してください")
	@Pattern(regexp="^[0-9]+$", message="半角数字で入力してください")
	private String salary;
	/** 性格 */
	@NotBlank(message = "特性を入力してください")
	private String characteristics;
	/** 扶養人数 */
	@Pattern(regexp="^[0-9]+$", message="半角数字で入力してください")
	private String dependentsCount;
	
	@Override
	public String toString() {
		return "InsertEmployeeForm [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender
				+ ", hireDate=" + hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address="
				+ address + ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	
	
}

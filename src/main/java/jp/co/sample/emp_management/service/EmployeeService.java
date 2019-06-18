package jp.co.sample.emp_management.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.domain.Employee;
import jp.co.sample.emp_management.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * 従業員情報を全件取得します.
	 * 
	 * @return　従業員情報一覧
	 */
	public List<Employee> showList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	/**
	 * 渡された文字列を含む名前の従業員情報を入社日順で取得.
	 * 
	 * @param name 検索する文字列
	 * @return 従業員情報 従業員が存在しない場合はサイズ0件の従業員一覧を返す
	 */
	public List<Employee> showResultByName(String name){
		List<Employee> employeeList = employeeRepository.findByName(name);
		return employeeList;
	}
	
	/**
	 * 従業員情報を取得します.
	 * 
	 * @param id ID
	 * @return 従業員情報
	 * @throws 検索されない場合は例外が発生します
	 */
	public Employee showDetail(Integer id) {
		Employee employee = employeeRepository.load(id);
		return employee;
	}
	
	/**
	 * 従業員情報を更新します.
	 * 
	 * @param employee　更新した従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
	
	/**
	 * 従業員情報を登録します.
	 * 
	 * @param employee 登録する従業員情報
	 */
	synchronized public void insert(Employee employee, MultipartFile imageFile) {
		
		int id = employeeRepository.getMaxId() + 1;
		String image = "";
		System.out.println(imageFile.getOriginalFilename());
		
		try {
			if(!imageFile.isEmpty()) {
				image = "emp_" + id + ".png";
				File uploadFile = new File("src/main/resources/static/img/" + image);
				byte[] bytes = imageFile.getBytes();
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(uploadFile));
				output.write(bytes);
				output.close();
			}else {
				image = "default.png";
			}
		} catch (Exception e) {
			System.out.println("画像がアップロードできませんでした。");
			System.err.println(e);
		}
		
		employee.setId(id);
		employee.setImage(image);
		
		System.out.println(employee);
		employeeRepository.insert(employee);
	}
	
	/**
	 * 従業員IDの最大値を求める.
	 * 
	 * @return IDの最大値
	 */
	public Integer getMaxId() {
		return employeeRepository.getMaxId();
	}
	
	/**
	 * メールアドレスが重複していないかチェック.
	 * 
	 * @param mailAdress メールアドレス
	 * @return 従業員情報 存在しない場合はnullを返す
	 */
	public Employee mailCheck(String mailAddress) {
		Employee employee = employeeRepository.findByMailAddress(mailAddress);
		return employee;
	}
}

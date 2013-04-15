package org.exitsoft.exercises.entity.account;

/**
 * 组实体类
 * 
 * @author vincent
 *
 */
public class Group {
	
	//组名称
	private String name;
	
	//备注
	private String remark;
	
	public Group() {
		
	}
	
	/**
	 * 获取组名称 
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置组名称
	 * 
	 * @param name 组名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取备注
	 * 
	 * @return String
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 * 
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

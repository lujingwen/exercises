package org.exitsoft.exercises.entity.account;

/**
 * 资源实体类
 * 
 * @author vincent
 *
 */
public class Resource {
	
	//资源名称
	private String name;
	//controller路径
	private String controllerPath;
	//备注
	private String remark;
	
	public Resource() {
		
	}
	
	/**
	 * 获取资源名称
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置资源名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取controller路径 
	 * 
	 * @return String
	 */
	public String getControllerPath() {
		return controllerPath;
	}

	/**
	 * 设置controller路径
	 * 
	 * @param controllerPath controller路径
	 */
	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}

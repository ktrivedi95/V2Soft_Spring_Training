package com.v2soft.training.datamodel;
// Generated Oct 16, 2019 11:18:30 AM by Hibernate Tools 5.1.10.Final

/**
 * EmployeeLoginId generated by hbm2java
 */
public class EmployeeLoginIdMod implements java.io.Serializable {

	private String username;
	private String employeeId;

	public EmployeeLoginIdMod() {
	}

	public EmployeeLoginIdMod(String username, String employeeId) {
		this.username = username;
		this.employeeId = employeeId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmployeeLoginIdMod))
			return false;
		EmployeeLoginIdMod castOther = (EmployeeLoginIdMod) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getEmployeeId() == castOther.getEmployeeId())
						|| (this.getEmployeeId() != null && castOther.getEmployeeId() != null
								&& this.getEmployeeId().equals(castOther.getEmployeeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode());
		return result;
	}

}

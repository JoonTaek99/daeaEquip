package com.daea.dtos;

import java.util.Date;

public class EquiDto {
	
	private int seq;
	private String id;
	private String model;
	private String manufacturer;
	private String operator;
	private String department;
	private String IP;
	private Date acqdate;
	
	public EquiDto() {
    }



	@Override
	public String toString() {
		return "EquiDto [seq=" + seq + ", id=" + id + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", operator=" + operator + ", department=" + department + ", IP=" + IP + ", acqdate=" + acqdate + "]";
	}



	public EquiDto(int seq, String id, String model, String manufacturer, String operator, String department, String iP,
			Date acqdate) {
		this.seq = seq;
		this.id = id;
		this.model = model;
		this.manufacturer = manufacturer;
		this.operator = operator;
		this.department = department;
		IP = iP;
		this.acqdate = acqdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public Date getAcqdate() {
		return acqdate;
	}

	public void setAcqdate(Date acqdate) {
		this.acqdate = acqdate;
	}
    
  
	

	
	
	

}
package com.netdeal.crud.createpassword.utils;

public enum PasswordStatus {
	
	FORTE,
	BOM,
	MEDIANA,
	RUIM;
	
	public static PasswordStatus getStatus(PasswordStatus passwordStatus) {
		return passwordStatus;
	}

}

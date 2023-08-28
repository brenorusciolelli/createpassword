package com.netdeal.crud.createpassword.utils;

public enum PasswordStatus {
	
	FORTE,
	BOM,
	MEDIANA,
	FRACA,
	RUIM;
	
	public static PasswordStatus getStatus(PasswordStatus passwordStatus) {
		return passwordStatus;
	}

}

package com.joyce.reps.serverInterface;

//PreList  ---预购清单文件
class PreList {
	byte[] patient = new byte[12]; // 病人姓名
	byte[] sex = new byte[5];
	byte[] age = new byte[5];
	byte[] ID = new byte[5];
	byte[] feibie = new byte[10];
	byte[] address = new byte[100];
	byte[] content = new byte[800];
	byte[] shop = new byte[12];
	byte[] doctor = new byte[12];
	byte[] pharmacist = new byte[12];
	byte[] phone = new byte[15];
	byte[] selfreport = new byte[50]; // 患者自述
	byte[] filename = new byte[100];
	byte[] date = new byte[10];

	public static int size = 12 + 5 + 5 + 5 + 10 + 100 + 800 + 12 + 12 + 12
			+ 15 + 50 + 100 + 10;

	// 将FileInfo对象转化为byte数组
	public byte[] getPreListBytes() {
		byte[] buf = new byte[size];
		// patient
		System.arraycopy(patient, 0, buf, 0, patient.length);
		// sex
		System.arraycopy(sex, 0, buf, 12, sex.length);
		// age
		System.arraycopy(age, 0, buf, 17, age.length);
		// ID
		System.arraycopy(ID, 0, buf, 22, ID.length);
		// feibie
		System.arraycopy(feibie, 0, buf, 27, feibie.length);
		// address
		System.arraycopy(address, 0, buf, 37, address.length);
		// content
		System.arraycopy(content, 0, buf, 137, content.length);
		// shop
		System.arraycopy(shop, 0, buf, 937, shop.length);
		// doctor
		System.arraycopy(doctor, 0, buf, 949, doctor.length);
		// pharmacist
		System.arraycopy(pharmacist, 0, buf, 961, pharmacist.length);
		// phone
		System.arraycopy(phone, 0, buf, 973, phone.length);
		// selfreport
		System.arraycopy(selfreport, 0, buf, 988, selfreport.length);
		// filename
		System.arraycopy(filename, 0, buf, 1038, filename.length);
		// date
		System.arraycopy(date, 0, buf, 1138, date.length);
		return buf;
	}

	// 将byte数组转化为类对象
	public static PreList getPreList(byte[] buf) {
		PreList p = new PreList();
		byte[] temp = null;
		// patient
		System.arraycopy(buf, 0, temp, 0, 12);
		p.patient = temp;
		// sex
		System.arraycopy(buf, 12, temp, 0, 5);
		p.sex = temp;
		// age
		System.arraycopy(buf, 17, temp, 0, 5);
		p.age = temp;
		// ID
		System.arraycopy(buf, 22, temp, 0, 5);
		p.ID = temp;
		// feibie
		System.arraycopy(buf, 27, temp, 0, 10);
		p.feibie = temp;
		// address
		System.arraycopy(buf, 37, temp, 0, 100);
		p.address = temp;
		// content
		System.arraycopy(buf, 137, temp, 0, 800);
		p.content = temp;
		// shop
		System.arraycopy(buf, 937, temp, 0, 12);
		p.shop = temp;
		// doctor
		System.arraycopy(buf, 949, temp, 0, 12);
		p.doctor = temp;
		// pharmacist
		System.arraycopy(buf, 961, temp, 0, 12);
		p.pharmacist = temp;
		// phone
		System.arraycopy(buf, 973, temp, 0, 15);
		p.phone = temp;
		// selfreport
		System.arraycopy(buf, 988, temp, 0, 50);
		p.selfreport = temp;
		// filename
		System.arraycopy(buf, 1038, temp, 0, 100);
		p.filename = temp;
		// date
		System.arraycopy(buf, 1138, temp, 0, 10);
		p.date = temp;
		return p;
	}
}

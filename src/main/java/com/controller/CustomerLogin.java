package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.CustomerLoginEntity;
import com.model.CustomerLoginRemote;

@ManagedBean(name="cl", eager=true)
public class CustomerLogin{
	
		String customername;
		int accno;
		String pass;
		
		@EJB(lookup = "java:global/EP-PROJECT/CustomerLoginManager!com.model.CustomerLoginRemote")
		CustomerLoginRemote clr;
		public String getCustomername() {
			return customername;
		}
		public void setCustomername(String customername) {
			this.customername = customername;
		}
		public int getAccno() {
			return accno;
		}
		public void setAccno(int accno) {
			this.accno = accno;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public void callEjbInsert() {
			CustomerLoginEntity E = new CustomerLoginEntity();
			E.setCustomername(customername);
			E.setAccno(accno);
			E.setPass(pass);
			clr.insert(E);
			
		}

	

}

package com.model;

import javax.ejb.Remote;

import com.entity.CustomerLoginEntity;

@Remote
public interface CustomerLoginRemote {
	public void insert(CustomerLoginEntity e);
	
	

}

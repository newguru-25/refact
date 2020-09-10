package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;


import org.junit.Before;
import org.junit.Test;

import com.refactorizando.refact.Demo;


public class DemoTest {
	static final String GET_PATH_USER=System.getProperty("user.home");
	Demo conexionBd;
	Map<String, String> dbParamsMap=new HashMap<String, String>();
	 
    @Before
    public void init() {
//    configuracion para el contenedor docker
//    	dbParamsMap.put("userName", "sa");
//		dbParamsMap.put("password", "password");
//		dbParamsMap.put("dbms", "mysql");
//		dbParamsMap.put("serverName", "mysql-container");
//		dbParamsMap.put("dataBase", "test");
//		dbParamsMap.put("portNumber", "3306");		
//		dbParamsMap.put("logFileFolder", GET_PATH_USER+"/root");

//    	configuracion para window localhost
    	dbParamsMap.put("userName", "root");
		dbParamsMap.put("password", "");
		dbParamsMap.put("dbms", "mysql");
		dbParamsMap.put("serverName", "localhost");
		dbParamsMap.put("dataBase", "test");
		dbParamsMap.put("portNumber", "3306");		
		dbParamsMap.put("logFileFolder", GET_PATH_USER+"/Desktop");
    }
	
	 @Test
	    public void logMessage() throws Exception { 
		 Map<String, Object> expect = new HashMap<String, Object>();
		 expect.put("Mensaje", "Successful");
		 expect.put("status", Boolean.TRUE);
//			initializedSelective flag es el penultimo parametro del constructor
//			initializedSelective=true => registra solo errores o solo errores y advertencia, siempre y cuando cumpla la condicion 
//		    y tambien =>this.logError && !this.logWarning o  this.logError && this.logWarning
//			El flag initializedSelective=false => registrara grave, advertencia , info
			conexionBd=new Demo(true, true, true, true, true, true,false, dbParamsMap);	  
			Map<String, Object>  actual=conexionBd.logMessage("mi mensaje");
		assertTrue(expect.equals(actual));							

	    }
}

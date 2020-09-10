package com.refactorizando.refact;

import java.util.HashMap;
import java.util.Map;
public class Ejecutar {	 
	
	public static void main(String[] args) throws Exception {
		
		Map<String, String> dbParamsMap=new HashMap<String, String>();
		
		dbParamsMap.put("userName", "root");
		dbParamsMap.put("password", "");
		dbParamsMap.put("dbms", "mysql");
		dbParamsMap.put("serverName", "localhost");
		dbParamsMap.put("dataBase", "test");
		dbParamsMap.put("portNumber", "3306");		
		dbParamsMap.put("logFileFolder", "C:\\Users\\Luiss\\Desktop\\prueba");
		
//		initializedSelective flag es el penultimo parametro del constructor
//		initializedSelective=true => registra solo errores o solo errores y advertencia, siempre y cuando 
//		cumpla esta condicion this.logError && !this.logWarning o  this.logError && this.logWarning
//		initializedSelective=false => registra grave, advertencia , info		
		
		Demo conexionBd=new Demo(true, true, true, true, true, false,true, dbParamsMap);			    
		
		conexionBd.logMessage("mi mensaje");
		
	}
	

}

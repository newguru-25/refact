package com.comentario.refact;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


//Cambiamos las propiedades a tipo dinamico
public class Demo {
//	Creamos una instancia logger para nuestra clase de la siguiente forma
//	private static Logger logger = Logger.getLogger(Demo.class.getName());
	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;
	private boolean initialized;
	private static Map dbParams;
	private static Logger logger;

//	Necesitamos agregar un parametro adicional para eligir solo errores o advertencia
	public Demo(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam, boolean logMessageParam,
			boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {
//		logger = Logger.getLogger("MyLog");
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = dbParamsMap;
	}

//  como buena practica debe poseer el standar camelCase logMessage
//	y llamar el metodo desde la anotacion Test y ademas podemos enviar los valores al contrcutor
//	 Una vez construido el contructor con los parametros 
//	no necesitamos => boolean message, boolean warning, boolean error debido que en el contructor ya le enviamos esos 
//	parametros
	public static void LogMessage(String messageText, boolean message, boolean warning, boolean error)
			throws Exception {
//       Este metodo para que tenga efecto necesita almacenarse en una variable
		messageText.trim();

//    	Debido que no elimina los espacios en blanco por lo tanto esta validacion tiene inconsistencias
		if (messageText == null || messageText.length() == 0) {
//			Error de compilacion debido que el metodo LogMessage es de tipo void
			return;
		}

//		si lo manejamos con el contexto dinamic this,
//		las propiedades se llamarian de la siguiente forma: 
//		this.clogToConsole, this.logToFile , this.logToDatabase
		if (!logToConsole && !logToFile && !logToDatabase) {
//        	Como buena practica se recomienda personalizar las excepciones en una clase aparte para manejar los errores
//			mas espeficicos
			throw new Exception("Invalid configuration");
		}

//		Se esta obteniendo los mismos valores dos veces, desde la propiedades de la clase y los parametros  
//		del metodo LogMessage
		
//		Suficiente con la siguiente expresion: if (!message && !warning && !error) 
//		para obtener solo una vez los parametros con eso seria suficiente
		if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
//        	Como buena practica se recomienda personalizar las excepciones en una clase aparte y no de la clase 
//        	generica exception
			throw new Exception("Error or Warning or Message must be specified");
		}

		Connection connection = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", dbParams.get("userName"));
		connectionProps.put("password", dbParams.get("password"));

//    	*1)Todo metodo que pueda arrojar una exception mas aun cuando se abre una conexion a la base de datos
//		se deben manejar en un block trycatch y finally para cerrar la conexion
//  *2) La conexion con la base de datos generan recursos al servidor por lo tanto genera mal rendimiento a la aplicacion
//		en resumen falto el metodo conection.close() al metodo;
//		en conclusion el cuerpo del metodo debe en estar en block try catch
		connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
				+ ":" + dbParams.get("portNumber") + "/", connectionProps);

		int t = 0;
//		message && logMessage Tienen el mismo valor automaticamente cuando la clase se contruye, como buena practica se recomienda
//		usar la propiedad de la clase  quedando de la siguiente forma if (logMessage)
		if (message && logMessage) {
			t = 1;
		}

//		error && logError Tienen el mismo valor automaticamente cuando la clase se contruye, como buena practica se recomienda
//		usar la propiedad de la clase  quedando de la siguiente forma if (logError)
		if (error && logError) {
			t = 2;
		}
//		error && logError Tienen el mismo valor automaticamente cuando la clase se contruye, como buena practica se recomienda
//		usar la propiedad de la clase  quedando de la siguiente forma if (logWarning)
		if (warning && logWarning) {
			t = 3;
		}

//		estas dos lineas de codigo deben estar despues de DriverManager.getConnection para un codigo mas facil de leer
//		no es necesario mantenerlo lejos y afecteria en nada el cambio
		Statement stmt = null;
		stmt = connection.createStatement();

// Una varaible no necesita establecer su valor como null, si su proposito es concatenar con otra cadenas 
//		debe ser inicializa de la siguiente forma	String l = ""; y concatenar con la expresion de la siguiente forma l += "cadena"
		String l = null;

//		se crea El archivo correctamente
		File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");

//		Se valida que se genere el archivo si no existe
		if (!logFile.exists()) {
			logFile.createNewFile();
		}

//		preparamos el handler para mostrar los log en un file
		FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
		ConsoleHandler ch = new ConsoleHandler();

//		error && logError Tienen el mismo valor automaticamente cuando la clase se contruye, como buena practica se recomienda
//		usar la propiedad de la clase  quedando de la siguiente forma if (logWarning)
		if (error && logError) {
//	REFACTORIZACION :
//			l += "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
			l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}
//		error && logError Tienen el mismo valor automaticamente cuando la clase se contruye, como buena practica se recomienda
//		usar la propiedad de la clase  quedando de la siguiente forma if (logWarning)
		if (warning && logWarning) {//		
//			l += "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
			l = l + "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}
//		message && logMessage Tienen el mismo valor automaticamente cuando la clase se contruye, como buena practica se recomienda
//		usar la propiedad de la clase  quedando de la siguiente forma if (logMessage)
		if (message && logMessage) {
//			l=""
//			l += "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
//			La variable l nunca se usa por lo tanto no tiene sentido establecer un valora dicha variable si nunca se usara
			l = l + "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}

//		para una mejor lectura recomnedaria subirlo
//		debido que no tiene que pasar por proceso de validaacion
		if (logToFile) {
//		 registramos los log en un file creado anteriormente
			logger.addHandler(fh);
			logger.log(Level.INFO, messageText);
		}

		if (logToConsole) {
//			los registramos en un file creado anteriormente
			logger.addHandler(ch);
			logger.log(Level.INFO, messageText);
		}

		if (logToDatabase) {
//			String.valueOf(t) no esta conviertiendo la variable t de tipo(int) a un  String.
//			para que tenga efecto necesita almacenar en un variable la expresion  String.valueOf(t)	
			
//			la variable message que se obtiene como parametros es un valor booleano
//			no cumple con el estandar de buenas practicas y ademas de generar inconsistencia
			stmt.executeUpdate("insert into Log_Values('" + message + "', " + String.valueOf(t) + ")");
		}			
	

//		Una vez terminaodo de registrar cerramos la conexion con la base de datos connection.close()
//		esto puede generar perdida de memoria en el servidor si no se administra de buena manera

	}
}

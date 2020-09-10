package com.refactorizando.refact;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
	private static Logger logger = Logger.getLogger(Demo.class.getName());
	private static final String CAMPO_LOG = "DESC_LOG";
	private static final String ERROR = "ERROR";
	private static final String WARNING = "WANING";
	private static final String MESSAGE = "MESSAGE";
	private boolean logToFile;
	private boolean logToConsole;
	private boolean logMessage;
	private boolean logWarning;
	private boolean logError;
	private boolean initializedSelective;
	private boolean logToDatabase;
	private Map<String, String> dbParams;

	public Demo(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam, boolean logMessageParam,
			boolean logWarningParam, boolean logErrorParam, boolean initializedSelective,
			Map<String, String> dbParamsMap) {		
		this.logMessage = logMessageParam;
		this.logWarning = logWarningParam;
		this.logError = logErrorParam;
		this.logToDatabase = logToDatabaseParam;
		this.logToFile = logToFileParam;
		this.logToConsole = logToConsoleParam;
		this.dbParams = dbParamsMap;
		this.initializedSelective = initializedSelective;
	}
	

	public Map<String, Object> logMessage(String messageText) throws BadExpresion, SQLException, ClassNotFoundException, IOException {
		
		Map<String, Object> result= new HashMap<String, Object>();
		
		Statement statement = null;
		Connection connection = null;
		String storeValue = "";
		messageText = messageText.trim();

		try {
			connection = this.conecctionMysql();

			statement = connection.createStatement();

			if (messageText == null || messageText.length() == 0) {
				throw new BadExpresion("Name cannot be null or empty string");
			}
			if (!this.logToConsole && !this.logToFile && !this.logToDatabase) {
				throw new BadExpresion("Invalid configuration");
			}
			if (!this.logError && !this.logMessage && !this.logWarning) {
				throw new BadExpresion("Error or Warning or Message must be specified");
			}

			File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");

			FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");

			ConsoleHandler ch = new ConsoleHandler();

			if (this.logToFile)
				logger.addHandler(fh);

			if (!logFile.exists())
				logFile.createNewFile();

			if (this.initializedSelective) {
				if (this.logError && !this.logWarning) {
//					registra solo errores
					storeValue += ERROR + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
					if (this.logToDatabase) {
						this.insertRow(statement, storeValue);
						storeValue="";
					}
					logger.log(Level.SEVERE, messageText);
				} else if (this.logError && this.logWarning) {
//				registra  errores y advertencia
					storeValue += ERROR + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
					this.insertRow(statement, storeValue);
					storeValue="";
					logger.log(Level.SEVERE, messageText);
					storeValue += WARNING + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
							+ messageText;
					this.insertRow(statement, storeValue);
					storeValue="";
					logger.log(Level.WARNING, messageText);
				} else {
					throw new BadExpresion(
							"ERROR Tienes dos opciones: this.logError= true  && this.logWarning = false => para registrar solo errores"
									+ "this.logError=true && this.logWarning=true => para registrar errores y warning");
				}
			} else {
//		registrar todo info,error, warning		
				if (this.logMessage) {
					storeValue += MESSAGE + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
							+ messageText;
					this.insertRow(statement, storeValue);
					storeValue="";
					logger.log(Level.INFO, messageText);
				}
				if (this.logWarning) {
					storeValue += WARNING + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
							+ messageText;
					this.insertRow(statement, storeValue);
					storeValue="";
					logger.log(Level.WARNING, messageText);
				}
				if (this.logError) {
					storeValue += ERROR + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
					this.insertRow(statement, storeValue);
					storeValue="";
					logger.log(Level.SEVERE, messageText);
				}
			}

			if (this.logToConsole)
				logger.addHandler(ch);

			result.put("Mensaje", "Successful");
			result.put("status", Boolean.TRUE);
			return result;
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, e.getMessage());
			throw new NullPointerException();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
			throw new SQLException();
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage());
			throw new ClassNotFoundException();
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
			throw new IOException();
		}catch (BadExpresion e) {
			
			throw new BadExpresion(e.getMessage());
		}
		finally {
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
		}
				
	}

	private Connection conecctionMysql() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.dbParams.get("userName"));
		connectionProps.put("password", this.dbParams.get("password"));
		connection = DriverManager
				.getConnection(
						"jdbc:" + this.dbParams.get("dbms") + "://" + this.dbParams.get("serverName") + ":"
								+ this.dbParams.get("portNumber") + "/" + this.dbParams.get("dataBase"),
						connectionProps);
		return connection;
	}

	private void insertRow(Statement statement, String value) throws SQLException {
		statement.executeUpdate("INSERT INTO log (" + CAMPO_LOG + ")" + "VALUES('" + value + "')");
	}

}

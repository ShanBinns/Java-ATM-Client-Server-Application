/**
 * Driver class which starts the Server program
 * @author SBINNS
 *
 */
package driver;

import network.Server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		
		logger.info("Starting Server");
		new Server();

	}
}

/**
 * Driver class which starts the Client program
 * @author SBINNS
 *
 */
package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import view.WelcomeScreen;



public class Driver {
	private static final Logger logger = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
			
		logger.info("Start of the Program");
		new WelcomeScreen();
	   		

	}
}

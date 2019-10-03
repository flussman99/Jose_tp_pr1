/**
 * 
 */
package tp.p1;

import java.util.Scanner;

/**
 * @author gabri
 *
 */





public class Command {
	
	 public enum action{
		SHOOT, SHOCKWAVE, NONE, LIST,RESET, HELP, EXIT, MOVE;
	}
	  
	
	public Command(){
		
	}
	
	/**
	 * Metodo que parsea la entrada del comando
	 * @param command
	 * @return action
	 * */
	public action verifyCommand(String command) {
		// TODO Auto-generated method stub
		char firstLetter= command.charAt(0);
		if(command.equalsIgnoreCase("shoot")|| firstLetter=='s' || firstLetter=='S' || command.contains("[S]") || command.contains("[s]")){
			 return action.SHOOT;
		}else if(command.equalsIgnoreCase("shockwave") || firstLetter=='w' || firstLetter=='W' || command.contains("[W]") || command.contains("[w]")){
			return action.SHOCKWAVE;
		}else if(command.equalsIgnoreCase("none")|| firstLetter=='n' || firstLetter=='N' || command.contains("[N]") || command.contains("[n]") ||command.equalsIgnoreCase("")){
			return action.NONE;
		}else if(command.equalsIgnoreCase("list")|| firstLetter=='l' || firstLetter=='L' || command.contains("[L]") || command.contains("[l]")){
			return action.LIST;
		}else if(command.equalsIgnoreCase("reset")|| firstLetter=='r' || firstLetter=='R' || command.contains("[R]") || command.contains("[r]")){
			return action.RESET;
		}else if(command.equalsIgnoreCase("help")|| firstLetter=='h' || firstLetter=='H' || command.contains("[H]") || command.contains("[h]")){
			return action.HELP;
		}else if(command.equalsIgnoreCase("exit")|| firstLetter=='e' || firstLetter=='E' || command.contains("[E]") || command.contains("[e]")){
			return action.EXIT;
		}else if(command.equalsIgnoreCase("move")|| firstLetter=='m' || firstLetter=='M' || command.contains("[M]") || command.contains("[m]")){
			return action.MOVE;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "try introducing: "
					+ "move, m or [m]. \n"
					+ "shoot, s or [s]. \n"
					+ "shockWave, w or [w]. \n"
					+ "list, l or [l]. \n"
					+ "reset, r, or [r]. \n"
					+ "help, h or [h]. \n"
					+ "exit, e or [e]. \n"
					+ "none, n or [n].\n";
	}

	
	
	

}

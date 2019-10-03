/**
 * 
 */
package tp.p1.model;

import java.util.Random;
import java.util.Scanner;

import tp.p1.Board;
import tp.p1.Command;
import tp.p1.Command.action;
import tp.p1.GameRules;
import tp.p1.controller.Controller;
import tp.p1.list.BombList;
import tp.p1.list.DestroyerShipList;
import tp.p1.list.RegularShipList;

/**
 * @author gabri
 *
 */
public class Game {

	private static final int NUM_REGULAR_SHIP=8;
	private static final int NUM_DESTROYER_SHIP=8;
	private static final int NUM_BOMBS=8;
	private Board board;
	private RegularShipList listaRegularShip;
	private DestroyerShipList listaDestroyerShipList;
	private BombList listaBombList;
	private Ovni ovni;
	private Misil misil;
	private UCMShip player;
	private DestroyerShip destructor;
	private RegularShip regular;
	private int ciclosJugados;
	private int puntuacionJugador;
	private Random rand;
	private Scanner sc;
	private GameRules rules;
	private Controller control;
	
	/**
	 * Construct method
	 */
	
	public Game() {
		// TODO Auto-generated constructor stub
		this.ciclosJugados=0;
		this.puntuacionJugador=0;
		this.listaRegularShip= new RegularShipList();
		this.listaDestroyerShipList = new DestroyerShipList();
		this.listaBombList = new BombList();
		this.sc= new Scanner(System.in);
		this.rules = new GameRules();
		this.board=new Board();
	}
	
	public void parseCommand(){
		Command command = new Command();
		System.out.println("Escribe un comando:");
		String cmd = sc.nextLine();
		action action = command.verifyCommand(cmd);
		 
		switch(action) {
	      case SHOOT:
	        player.shoot();
	        break;
	      case MOVE:
	    	 
	    	 //player.move(direccion, distancia)
	         break;
	      case HELP:
	    	  rules.toString();
	    	  break;
		  case LIST:
			  list();
		  break;
		  case SHOCKWAVE:
			  player.activaShockWave();
			  break;
		  case RESET:
			  	reset();
			  break;
		  case NONE:
			  	none();
			  break;
		  case EXIT:
			  exit();
			  break;
		  default:
			  System.out.println("Comando invalido, vuelva a intentarlo.");
		  break;
	        
	    }
		
		
	  }
	
	
	public void reset(){
		
	}
	
	public void none(){
		
		System.out.println("No realizamos ninguna accion");
		
	}
	public void exit(){
		
		control.endGame() ;
		
		
		System.out.println("Game Over");
		
	}
	public void update(){
		//llama al update de cada objeto
	}
	
	public void list() {
		
		System.out.println("[R]egular Ship:"+" "+ "Points:"+ regular.getPuntos()+"-"+ "Harm: 0 "+ "-"+ "Shield:"+regular.getResistencia() );
		
		System.out.println("[D]estroyer Ship:"+" "+ "Points:"+ destructor.getPuntos()+"-"+ "Harm:"+ destructor.getDano()+ "-"+ "Shield:"+destructor.getResistencia() );

		System.out.println("[O]vni:"+" "+ "Points:"+ ovni.getPuntos()+"-"+ "Harm: 0 "+ "-"+ "Shield:"+ovni.getResistencia() );
		
		System.out.println("^__^:"+" "+"Harm:"+ player.getDano()+ "-"+ "Shield:"+player.getResistencia() );

	}
	
	public void help(GameRules rules){
		rules.toString();
	}
	

	/**
	 * 
	 * @param i ,j
	 * @return
	 * */
	public String toStringObjectAt(int row, int col) {
		// TODO Auto-generated method stub"
			if(player.getPosicionX()==row && player.getPosicionY()==col){
				return player.toString();
			}else if(listaRegularShip.isHere(row, col)){
				return listaRegularShip.toString();
			}else if(listaDestroyerShipList.isHere(row,col)){
				return listaDestroyerShipList.toString();
			}else if(listaBombList.isHere(row,col)){
				return listaBombList.toString();
			}if(ovni.getPosicionX()==row && ovni.getPosicionY()==col){
				return player.toString();
			}if(misil.getPosicionX()==row && misil.getPosicionY()==col){
				return player.toString();
			}else{
				return "";
			}
	}
			
		
	

	
	/**
	 * Metodo que aumenta puntos del jugador
	 * @param puntos
	 * */
	public void aumentaPuntos(int puntos) {
		// TODO Auto-generated method stub
		this.puntuacionJugador+= puntos;
		
	}
	
	/**
	 * Metodo que proporciona informacion de la partida
	 * @params jugador, regularAlien, destroyerAlien
	 * */
	public void infoPartida(UCMShip jugador, RegularShipList regularAlien, DestroyerShipList destroyerAlien){
		int life= jugador.getResistencia();
		int numberOfCycles= this.ciclosJugados;
		int points= this.puntuacionJugador;
		int remainingAliens= numShipsBoard();
	}
	
	/**
	 * Metodo que proporciona informacion de la partida
	 * @params= jugador, regularAlien, destroyerAlien
	 * */
	@Override
	public String toString() {
		return "life:";
	}
	
	
	/**
	 * Metodo que consulta el numero de naves enemigas en el tablero
	 * @return int
	 * */
	public int numShipsBoard(){
		int totalShips=0;
		totalShips+=listaRegularShip.length();
		totalShips+=listaDestroyerShipList.length();
		return totalShips;
	}
	
	
	/**
	 * Metodo que verifica si la celda esta vacia
	 * */
	public boolean cellAvailable(int row, int col){
		if(player.getPosicionX()==row && player.getPosicionY()==col){
			return false;
		}else if(listaRegularShip.isHere(row, col)){
			return false;
		}else if(listaDestroyerShipList.isHere(row,col)){
			return false;
		}else if(listaBombList.isHere(row,col)){
			return false;
		}if(ovni.getPosicionX()==row && ovni.getPosicionY()==col){
			return false;
		}if(misil.getPosicionX()==row && misil.getPosicionY()==col){
			return false;
		}else{
			return true;
		}
	}
	
	
	public void enemyAction(){
		//llama a la accion de la lista
	}
	
	
	
	

}

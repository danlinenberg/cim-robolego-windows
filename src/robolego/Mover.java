package robolego;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.Sound;

public class Mover {

//	static int TIME = 900;
	static NXTRegulatedMotor MotorL = Motor.A;
	static NXTRegulatedMotor MotorR = Motor.C;
	static Music music = new Music();


	public static void MoveBrick(int n){
		
//		long millis = System.currentTimeMillis();
		
		MotorR.setAcceleration(1000);
		MotorR.setSpeed(200);
		MotorL.setAcceleration(1000);
		MotorL.setSpeed(200);
		
		switch(n){
		case(102):
			Forward();
			break;
		case(98):
			Backward();
			break;
		case(114):
			Left();
			break;
		case(108):
			Right();
			break;
		case(115):
			stop();
			break;
		case(111):
			Boom();
			break;
		case(49):
			Powerup_HP();
			break;
		case(50):
			Powerup_BOMB();
			break;
		case(51):
			Powerup_GODMODE();
			break;
		case(52):
			Powerup_CONFUSION();
			break;
		case(119):
			Win();
			break;
		}

	}
	
	public static void Forward(){
		MotorL.forward();
		MotorR.forward();
	}
	
	public static void Backward(){
		MotorL.backward();
		MotorR.backward();
	}
	public static void Right(){
		MotorL.forward();
		MotorR.backward();
	}
	
	public static void Left(){
		MotorL.backward();
		MotorR.forward();
	}
	
	public static void stop(){
		MotorR.stop(true);
		MotorL.stop(true);
	}
	
	public static void Boom(){	
		music.musicPiano("G4", 800);
		music.musicPiano("D4", 800);
		music.musicPiano("C4", 800);
		music.musicPiano("B3", 800);
		music.musicPiano("Ab3", 3000);
		
	}
	
	public static void Powerup_HP(){
		music.musicPiano("Ab3", 300);
		music.musicPiano("B3", 300);
		music.musicPiano("D4", 300);
	}
	
	public static void Powerup_BOMB(){
		music.musicPiano("G5", 300);
		music.musicPiano("A3", 300);
		music.musicPiano("D5", 300);
	}
	
	public static void Powerup_GODMODE(){
		music.musicPiano("A#4", 300);
		music.musicPiano("Eb5", 300);
		music.musicPiano("G#5", 300);
	}
	
	public static void Powerup_CONFUSION(){
		music.musicPiano("D#5", 300);
		music.musicPiano("Eb3", 300);
		music.musicPiano("F#3", 300);
	}
	
	public static void Win(){
		MotorR.setAcceleration(500);
		MotorR.setSpeed(50);
		MotorL.setAcceleration(500);
		MotorL.setSpeed(50);
		MotorL.backward();
		MotorR.forward();
		
		//playing 'we are the champions'
		String[] melody1 = { "E4", "F4", "E4", 
			      "C4", "500", "A3",  "D4"};
		 
//		 String[] melody2 = {"A5", 
//			      "C5","A5", "D5", "1000", "D4", "E4", "D5","1000",
//			      "D4","C4","200","D4","C","200","B3"};
//		Music music = new Music();
		
		music.musicPiano("F4", 1000); //we.....
		Sound.pause(300);
		for (int i = 0; i < melody1.length; i++) {
			String note = melody1[i];
   	  		try{
   	  			Sound.pause(Integer.parseInt(note));
   	  		}catch(Exception e){
		         music.musicPiano(melody1[i], 500);
		         System.out.println(melody1[i]);   
   	  		}
   
     	} 
		music.musicPiano("A3", 1000);
		Sound.pause(600);
		music.musicPiano("C4", 600);
		music.musicPiano("F4", 1200); //and we'll...
	}
}  
 

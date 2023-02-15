package application;

public class Work {
	private static int step = 0;
	static boolean trig1 = false;
	static boolean trig2 = false;
	// PLC vars
	public static int status;
	public static int boot; // elindul a boot video
	public static int kapcsolo_tabla_done; // megjelenik a játék és játszható
	public static int oszcilloszkop_done;  // ha kész a játék elküldi a PLC-nek
	public static int fekete_doboz;	    	//ha bead akkor lejátsza a koordinata videot
	public static int oszcilloszkop_skip;  // ha skip akkor beáll megoldásra és várja hogy
	
	public static void run() throws InterruptedException {
		try {
			
			System.out.println(status);
			Thread.sleep(1000);
		if(status != 0 && status == 1) {
			switch(step) {
			case 0:// play boot video
				if(boot == 1) {
					//play boot video
					Thread.sleep(1000);
					System.out.println("BOOOOOOOOOT"+step);
					step++;
				}
				break;
			case 1:// wait for trigger to play oscilloscope
				if(kapcsolo_tabla_done == 1) {
					Thread.sleep(1000);
					System.out.println(Main.currentLevel[0]);
					
					while(trig1 != true) {
						System.out.println("seeeeeeeeeeeeeeeeeg");
						trig1 = Main.setSceneShow();		
					}
					
					if( Main.currentLevel[0] == 4 &&
						Main.currentLevel[1] == 4 &&
						Main.currentLevel[2] == 4 &&
						Main.currentLevel[3] == 4 &&
						Main.currentLevel[4] == 4 &&
						Main.currentLevel[5] == 4 &&
						Main.currentLevel[6] == 4
					  ) {
						Main.gameEnable = false;
						step++;
					}
					
					
					
				}
				
				break;
			case 2:
				if(fekete_doboz == 1) {
					//play fekete doboz video
					
				}
				
			}
			
		}else {
			// Reset
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
